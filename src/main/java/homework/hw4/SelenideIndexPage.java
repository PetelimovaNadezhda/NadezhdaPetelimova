package homework.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework.hw3.TextMain;
import homework.hw3.Users;
import homework.hw4.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// TODO Take look on HW-3, you have to use @FindBy annotation here
// TODO In general, you should use only Selenide assertions here !
/*
TODO It is NOT an IndexPage.
Basically, you should have 3 PO
1 Home/index page
2 DifferentElements page
3 Dates page

This pages should consist of different elements, you should not repeat yourself.
 */
public class SelenideIndexPage {

    private final SelenideElement leftSection = $(".log-sidebar");
    private final SelenideElement rightSection = $(".navigation-sidebar");
    private final ElementsCollection serviceMenuHeader = $(".dropdown-menu").$$(By.tagName("li"));
    private final SelenideElement userName = $("#user-name");
    private final ElementsCollection serviceMenu = $(".menu-title").$$(By.tagName("li"));
    private final SelenideElement logs = $(".info-panel-body.info-panel-body-log");
    private final SelenideElement userIcon = $("[id='user-icon']");
    private final SelenideElement login = $("[id='name']");
    private final SelenideElement pass = $("[id='password']");
    private final SelenideElement loginButton = $("[id='login-button']");
    private final ElementsCollection elements = $(".main-content-hg").find(".checkbox-row").findAll(".label-checkbox");
    private final ElementsCollection metals = $(".main-content-hg").findAll(".checkbox-row").last().findAll(".label-radio");
    private final SelenideElement colors = $(".main-content-hg").find(".colors").find(".uui-form-element");
    private final ElementsCollection buttons = $(".main-content-hg").findAll(".uui-button");
    private final SelenideElement leftRange = $$(".ui-slider-handle").first();
    private final SelenideElement rightRange = $$(".ui-slider-handle").last();
    private final SelenideElement sliderRange = $(".ui-slider-range");

    @Step
    void login(Users user) {
        userIcon.click();
        login.sendKeys(user.login);
        pass.sendKeys(user.password);
        loginButton.click();
    }

    @Step
    void userNameAssert(Users user) {
        userName.shouldHave(text(user.name));
    }

    @Step
    void checkLeft() {
        leftSection.isDisplayed();
    }

    @Step
    void checkRight() {
        rightSection.isDisplayed();
    }

    @Step
    void serviceMenu(ServiceSubcategory[] subcategory) {
        // TODO You should not find elements in PO method, use @FindBy
        $(".menu-title").click();
        List<String> listService = serviceMenu.texts();
        for (ServiceSubcategory name : subcategory) {
            assertTrue(listService.contains(name.text));
        }
    }

    @Step
    void serviceMenuHeader(ServiceSubcategory[] subcategory) {
        $(".dropdown-toggle").click();
        List<String> listService = serviceMenuHeader.texts();
        for (ServiceSubcategory name : subcategory) {
            assertTrue(listService.contains(name.text.toUpperCase()));
        }
    }

    @Step
    void checkBrowserTitle(TextMain name) {
        assertEquals(getWebDriver().getTitle(), name.text);
    }

    @Step
    void openDifferentElement() {
        $(".dropdown-toggle").click();
        // TODO That's really great, but why don't you parametrise this method ?
        serviceMenuHeader.findBy(text(ServiceSubcategory.DIFFERENT.text)).click();
    }

    @Step
    void selectCheckboxes(Elements element) {
        elements.findBy(text(element.text)).click();
    }

    @Step
    void selectRadio(Metals metal) {
        metals.findBy(text(metal.text)).click();
    }

    @Step
    void selectColor(Colors color) {
        colors.selectOptionContainingText(color.text);
    }

    @Step
    void assertLog(Regex regex) {
        String[] lines = logs
                .getText().split("\\r?\\n");
        assertTrue(lines[0].contains(regex.regex));
    }

    @Step
    void assertLogRange(int from, int to) {
        String[] lines = logs
                .getText().split("\\r?\\n");
        String log = lines[0] + lines[1];
        assertTrue(log.contains("Range 2(From):" + from + " link clicked"));
        assertTrue(log.contains("Range 2(To):" + to + " link clicked"));
    }

    @Step
    void checkInterface() {
        assertEquals(elements.size(), 4);
        assertEquals(metals.size(), 4);
        assertEquals(buttons.size(), 2);
        assertTrue(colors.isDisplayed());
    }

    @Step
    void openDatesPage() {
        // TODO This should not be here, take a look on HW2-3
        getWebDriver().manage().window().maximize();
        $(".dropdown-toggle").click();
        serviceMenuHeader.findBy(text(ServiceSubcategory.DATES.text)).click();
    }

    @Step
    void setRange(int left, int right) {
        //    System.out.println(leftRange.getAttribute("style").);
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("arguments[0].style.left='" + left + "%';\n" +
                "arguments[0].childNodes[0].innerHTML='" + left + "';\n", leftRange);
        leftRange.click();
        js.executeScript("arguments[0].style.left='" + right + "%';\n" +
                "arguments[0].childNodes[0].innerHTML='" + right + "';\n" +
                "arguments[1].style.left='" + left + "%';\n" +
                "arguments[1].style.width='" + (right - left) + "%'", rightRange, sliderRange);
        rightRange.click();
    }
}