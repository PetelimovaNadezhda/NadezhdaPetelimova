package homework.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework.hw3.TextMain;
import homework.hw3.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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


    public void login(Users user) {
        userIcon.click();
        login.sendKeys(user.login);
        pass.sendKeys(user.password);
        loginButton.click();
    }

    void userNameAssert(Users user) {
        userName.shouldHave(text(user.name));
    }

    void checkLeft() {
        leftSection.isDisplayed();
    }

    void checkRight() {
        rightSection.isDisplayed();
    }

    void serviceMenu(ServiceSubcategory[] subcategory) {
        $(".menu-title").click();
        List<String> listService = serviceMenu.texts();
        for (ServiceSubcategory name : subcategory) {
            assertTrue(listService.contains(name.text));
        }
    }

    public void serviceMenuHeader(ServiceSubcategory[] subcategory) {
        $(".dropdown-toggle").click();
        List<String> listService = serviceMenuHeader.texts();
        for (ServiceSubcategory name : subcategory) {
            assertTrue(listService.contains(name.text.toUpperCase()));
        }
    }

    void checkBrowserTitle(TextMain name) {
        assertEquals(getWebDriver().getTitle(), name.text);
    }

    void openDifferentElement() {
        $(".dropdown-toggle").click();
        serviceMenuHeader.findBy(text(ServiceSubcategory.DIFFERENT.text)).click();
    }

    void selectCheckboxes(Elements element) {
        elements.findBy(text(element.text)).click();
    }

    void selectRadio(Metals metal) {
        metals.findBy(text(metal.text)).click();
    }

    void selectColor(Colors color) {
        colors.selectOptionContainingText(color.text);
    }

    public void assertLog(Regex regex) {
        String[] lines = logs
                .getText().split("\\r?\\n");
        assertTrue(lines[0].contains(regex.regex));
    }

    public void assertLogRange(int from, int to) {
        String[] lines = logs
                .getText().split("\\r?\\n");
        if (!lines[1].contains("Range 2(From):" + from + " link clicked"))
            System.out.println(lines[1] + "; Range 2(From):" + from + " link clicked");
        if (!lines[0].contains("Range 2(To):" + to + " link clicked"))
            System.out.println(lines[0] + "; Range 2(To):" + to + " link clicked");
        assertTrue(lines[1].contains("Range 2(From):" + from + " link clicked"));
        assertTrue(lines[0].contains("Range 2(To):" + to + " link clicked"));
    }

    public void checkInterface() {
        assertEquals(elements.size(), 4);
        assertEquals(metals.size(), 4);
        assertEquals(buttons.size(), 2);
        assertTrue(colors.isDisplayed());
    }

    void openDatesPage() {
        $(".dropdown-toggle").click();
        serviceMenuHeader.findBy(text(ServiceSubcategory.DATES.text)).click();
    }

    void setRange(int left, int right) {
        Actions move = new Actions(getWebDriver());
        int sliderWidth = $(".uui-slider").getSize().getWidth();
        double index = sliderWidth / 100.0;
        double leftValue = Double.valueOf(leftRange.getAttribute("style").replaceAll("[^0-9]", ""));
        double rightValue = Double.valueOf(rightRange.getAttribute("style").replaceAll("[^0-9]", ""));
        int leftMove = (left - leftValue) * index;
        int rightMove = (right - rightValue) * index;
        move.dragAndDropBy(leftRange, leftMove, 0).build().perform();
        move.dragAndDropBy(rightRange, rightMove, 0).build().perform();
    }
}