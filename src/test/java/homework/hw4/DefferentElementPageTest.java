package homework.hw4;

import base.SelenideBase;
import com.sun.javafx.binding.StringFormatter;
import homework.hw3.TextMain;
import homework.hw3.Users;

import io.qameta.allure.Story;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.Format;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homework.hw3.Html.INDEX_HTML_URL;
import static homework.hw4.Colors.*;
import static homework.hw4.Elements.*;
import static homework.hw4.Metals.*;
import static homework.hw4.LogPatterns.*;
import static homework.hw4.ServiceSubcategory.DIFFERENT;

public class DefferentElementPageTest extends SelenideBase {
    private homework.hw4.SelenideIndexPage indexPage;
    private homework.hw4.DifferentElementsPage differentElementsPage;


    @BeforeMethod
    public void initTest() {
        //1 Open test site by URL
        open(INDEX_HTML_URL.htmlName);
        getWebDriver().manage().window().maximize();
        indexPage = page(homework.hw4.SelenideIndexPage.class);
        differentElementsPage = page(homework.hw4.DifferentElementsPage.class);
    }

    @Feature(value = "Interface")
    @Story(value = "Interface")
    @Test
    public void testEpamJdiPage4() {
        //2 Assert Browser title
        indexPage.checkBrowserTitle(TextMain.HOME_PAGE_TITLE);


        //3 Perform login
        indexPage.login(Users.PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.userNameAssert(Users.PITER);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        indexPage.serviceMenuHeader(ServiceSubcategory.values());

        //6 Click on Service subcategory in the left section and check that drop down contains options
        indexPage.serviceMenu(ServiceSubcategory.values());

        //7 Open through the header menu Service -> Different Elements Page
        indexPage.openPage(DIFFERENT);

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPage.checkInterface();

        //9 Assert that there is Right Section
        //10 Assert that there is Left Section
        differentElementsPage.checkSection();

        //11 Select checkboxes
        differentElementsPage.selectCheckboxes(WIND);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.assertLog(String.format(ELEMENTS.patterns, WIND.text, "true"));

        //11 Select checkboxes
        differentElementsPage.selectCheckboxes(WATER);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.assertLog(String.format(ELEMENTS.patterns, WATER.text, "true"));

        //13 Select radio
        differentElementsPage.selectRadio(SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.assertLog(String.format(METAL_COLOR.patterns, "metal", SELEN.text));

        //15 Select in dropdown
        differentElementsPage.selectColor(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        differentElementsPage.assertLog(String.format(METAL_COLOR.patterns, "Colors", YELLOW.text));

        //17 Unselect and assert checkboxes
        differentElementsPage.selectCheckboxes(WATER);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.assertLog(String.format(ELEMENTS.patterns, WATER.text, "false"));

        //17 Unselect and assert checkboxes
        differentElementsPage.selectCheckboxes(WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.assertLog(String.format(ELEMENTS.patterns, WIND.text, "true"));
    }
}
