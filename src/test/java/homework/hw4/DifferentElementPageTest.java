package homework.hw4;

import base.SelenideBase;
import homework.hw3.enums.TextMain;
import homework.hw3.enums.Users;

import homework.hw4.enums.ServiceSubcategory;
import homework.hw4.po.DifferentElementsPage;
import homework.hw4.po.SelenideIndexPage;
import io.qameta.allure.Story;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homework.hw3.enums.Html.INDEX_HTML_URL;
import static homework.hw4.enums.BooleanLiterals.FALSE;
import static homework.hw4.enums.BooleanLiterals.TRUE;
import static homework.hw4.enums.Colors.*;
import static homework.hw4.po.ElementTypes.COLORS;
import static homework.hw4.po.ElementTypes.METAL;
import static homework.hw4.enums.Elements.*;
import static homework.hw4.enums.Metals.*;
import static homework.hw4.enums.LogPatterns.*;
import static homework.hw4.enums.ServiceSubcategory.DIFFERENT;

public class DifferentElementPageTest extends SelenideBase {
    private SelenideIndexPage indexPage;
    private DifferentElementsPage differentElementsPage;

    @BeforeMethod
    public void initTest() {
        //1 Open test site by URL
        open(INDEX_HTML_URL.htmlName);
        getWebDriver().manage().window().maximize();
        indexPage = page(SelenideIndexPage.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }

    @Feature(value = "Interface")
    @Story(value = "InterfaceStory")
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
        differentElementsPage.checkInterfaceDifferentPage();

        //9 Assert that there is Right Section
        //10 Assert that there is Left Section
        differentElementsPage.checkSection();

        //11 Select checkboxes
        differentElementsPage.selectNatureElements(WIND);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.assertLog(String.format(ELEMENTS.patterns, WIND.text, TRUE.text));

        //11 Select checkboxes
        differentElementsPage.selectNatureElements(WATER);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.assertLog(String.format(ELEMENTS.patterns, WATER.text, TRUE.text));

        //13 Select radio
        differentElementsPage.selectMetal(SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.assertLog(String.format(METAL_COLOR.patterns, METAL.text, SELEN.text));

        //15 Select in dropdown
        differentElementsPage.selectColor(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        differentElementsPage.assertLog(String.format(METAL_COLOR.patterns, COLORS.text, YELLOW.text));

        //17 Unselect and assert checkboxes
        differentElementsPage.selectNatureElements(WATER);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.assertLog(String.format(ELEMENTS.patterns, WATER.text, FALSE.text));

        //17 Unselect and assert checkboxes
        differentElementsPage.selectNatureElements(WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.assertLog(String.format(ELEMENTS.patterns, WIND.text, FALSE.text));
    }
}
