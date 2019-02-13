package homework.hw4;

import base.SelenideBase;
import homework.hw3.TextMain;
import homework.hw3.Users;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class EpamSiteSlidersTest extends SelenideBase {
    private SelenideIndexPage indexPage;

    @BeforeMethod
    public void initTest() {
        //1 Open test site by URL
        // TODO This should be store via enum or constant
        open("https://epam.github.io/JDI/index.html");
        indexPage = page(SelenideIndexPage.class);
    }

    @Feature(value = "Slider")
    @Story(value = "Slider")
    @Test
    public void testEpamJdiPage4() {
        //2 Assert Browser title
        indexPage.checkBrowserTitle(TextMain.HOME_PAGE_TITLE);

        //3 Perform login
        indexPage.login(Users.PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.userNameAssert(Users.PITER);

        //5 Open through the header menu Service -> Dates Page
        indexPage.openDatesPage();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        indexPage.setRange(0, 100);

        //Assert that for "From" and "To" sliders there are logs rows with corresponding values
        indexPage.assertLogRange(0, 100);

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        indexPage.setRange(0, 0);

        //Assert that for "From" and "To" sliders there are logs rows with corresponding values
        indexPage.assertLogRange(0, 0);

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        indexPage.setRange(100, 100);

        //Assert that for "From" and "To" sliders there are logs rows with corresponding values
        indexPage.assertLogRange(100, 100);

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        indexPage.setRange(30, 70);

        //Assert that for "From" and "To" sliders there are logs rows with corresponding values
        indexPage.assertLogRange(30, 70);
    }
}
