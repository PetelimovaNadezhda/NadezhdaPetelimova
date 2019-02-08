package homework.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework.hw3.TextMain;
import homework.hw3.Users;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SelenideIndexPage {

    private static final SelenideElement logs = $(".info-panel-body.info-panel-body-log");
    private static final SelenideElement userIcon = $("[id='user-icon']");
    private static final SelenideElement login = $("[id='name']");
    private static final SelenideElement pass = $("[id='password']");
    private static final SelenideElement loginButton = $("[id='login-button']");
    private static final ElementsCollection elements = $(".main-content-hg").find(".checkbox-row").findAll(".label-checkbox");
    private static final ElementsCollection metals = $(".main-content-hg").findAll(".checkbox-row").last().findAll(".label-radio");
    private static final SelenideElement colors = $(".main-content-hg").find(".colors").find(".uui-form-element");
    private static final ElementsCollection buttons = $(".main-content-hg").findAll(".uui-button");

    public static void login(Users user) {
        userIcon.click();
        login.sendKeys(user.login);
        pass.sendKeys(user.password);
        loginButton.click();
    }

    public static void userNameAssert(Users user) {
        $("#user-name").shouldHave(text(user.name));
    }

    public static void serviceMenu(ServiceSubcategory[] subcategory) {
        $(".menu-title").click();
        List<String> listService = $(".menu-title").$$(By.tagName("li")).texts();
        for (ServiceSubcategory name : subcategory) {
            assertTrue(listService.contains(name.text));
        }
    }

    public static void serviceMenuHeader(ServiceSubcategory[] subcategory) {
        $(".dropdown-toggle").click();
        List<String> listService = $(".dropdown-menu").$$(By.tagName("li")).texts();
        for (ServiceSubcategory name : subcategory) {
            assertTrue(listService.contains(name.text.toUpperCase()));
        }
    }

    static void checkBrowserTitle(TextMain name) {
        assertEquals(getWebDriver().getTitle(), name.text);
    }

    public static void openDifferentElement() {
        $(".menu-title").$$(By.tagName("li")).findBy(Condition.text(ServiceSubcategory.DIFFERENT.text)).click();
    }

    public static void selectСheckboxes(Elements element) {
        elements.findBy(text(element.text)).click();
    }

    public static void selectRadio(Metals metal) {
        metals.findBy(text(metal.text)).click();
    }

    public static void selectColor(Colors color) {
        colors.selectOptionContainingText(color.text);
    }

    public static void assertLog(Regex regex) {
        String lines[] = logs
                .getText().split("\\r?\\n");
        if (!lines[0].contains(regex.regex)) System.out.println(lines[0] + " " + regex.regex);
        assertTrue(lines[0].contains(regex.regex));
    }

    public static void checkInterface() {
        assertEquals(elements.size(), 4);
        assertEquals(metals.size(), 4);
        assertEquals(buttons.size(), 2);
        assertTrue(colors.isDisplayed());
    }


}