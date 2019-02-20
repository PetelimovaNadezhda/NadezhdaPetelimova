package homework.hw4;

import base.SelenideBase;
import homework.hw3.enums.TextMain;
import homework.hw3.enums.Users;
import homework.hw4.po.DatesPage;
import homework.hw4.po.SelenideIndexPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homework.hw3.enums.Html.INDEX_HTML_URL;
import static homework.hw4.enums.ServiceSubcategory.DATES;

public class EpamSiteSlidersTest extends SelenideBase {
    private SelenideIndexPage indexPage;
    private DatesPage datesPage;

    @BeforeMethod
    public void initTest() {
        //1 Open test site by URL
        open(INDEX_HTML_URL.htmlName);
        getWebDriver().manage().window().maximize();
        indexPage = page(SelenideIndexPage.class);
        datesPage = page(DatesPage.class);
    }

    @Feature(value = "Slider")
    @Story(value = "SliderStory")
    @Test
    public void testEpamJdiPage4() {
        //2 Assert Browser title
        indexPage.checkBrowserTitle(TextMain.HOME_PAGE_TITLE);

        //3 Perform login
        indexPage.login(Users.PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.userNameAssert(Users.PITER);

        //5 Open through the header menu Service -> Dates Page
        indexPage.openPage(DATES);

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.setRange(0, 100);

        //Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.assertLogRange(0, 100);

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.setRange(0, 0);

        //Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.assertLogRange(0, 0);

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.setRange(100, 100);

        //Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.assertLogRange(100, 100);

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.setRange(30, 70);

        //Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.assertLogRange(30, 70);
    }
}
