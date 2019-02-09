package homework.hw4;

import base.SelenideBase;
import homework.hw3.TextMain;
import homework.hw3.Users;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class EpamSiteTest extends SelenideBase {
    private homework.hw4.SelenideIndexPage indexPage;

    @BeforeMethod
    public void initTest() {
        //1 Open test site by URL
        open("https://epam.github.io/JDI/index.html");
        indexPage = page(homework.hw4.SelenideIndexPage.class);
    }

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
        indexPage.openDifferentElement();

        //8 Check interface on Different elements page, it contains all needed elements
        indexPage.checkInterface();

        //9 Assert that there is Right Section
        indexPage.checkRight();

        //10 Assert that there is Left Section
        indexPage.checkLeft();

        //11 Select checkboxes
        indexPage.selectCheckboxes(Elements.WIND);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        indexPage.assertLog(Regex.WIND_TRUE);

        //11 Select checkboxes
        indexPage.selectCheckboxes(Elements.WATER);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        indexPage.assertLog(Regex.WATER_TRUE);

        //13 Select radio
        indexPage.selectRadio(Metals.SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        indexPage.assertLog(Regex.METAL_SELEN);

        //15 Select in dropdown
        indexPage.selectColor(Colors.YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        indexPage.assertLog(Regex.COLOR_YELLOW);

        //17 Unselect and assert checkboxes
        indexPage.selectCheckboxes(Elements.WATER);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        indexPage.assertLog(Regex.WATER_FALSE);

        //17 Unselect and assert checkboxes
        indexPage.selectCheckboxes(Elements.WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        indexPage.assertLog(Regex.WIND_FALSE);
    }
}
