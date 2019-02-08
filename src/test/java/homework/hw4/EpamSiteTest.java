package homework.hw4;

import base.SelenideBase;
import homework.hw3.Html;
import homework.hw3.TextMain;
import homework.hw3.Users;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static homework.hw4.SelenideIndexPage.*;

public class EpamSiteTest extends SelenideBase {
    @Test
    public void testEpamJdiPage4() {
        //1 Open test site by URL
        open(Html.INDEX_HTML_URL.htmlName);

        //2 Assert Browser title
        checkBrowserTitle(TextMain.HOME_PAGE_TITLE);

        //3 Perform login
        login(Users.PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        userNameAssert(Users.PITER);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        serviceMenuHeader(ServiceSubcategory.values());

        //6 Click on Service subcategory in the left section and check that drop down contains options
        serviceMenu(ServiceSubcategory.values());

        //7 Open through the header menu Service -> Different Elements Page
        openDifferentElement();

        //8 Check interface on Different elements page, it contains all needed elements
        checkInterface();

        //9 Assert that there is Right Section
        $(".navigation-sidebar").isDisplayed();

        //10 Assert that there is Left Section
        $(".log-sidebar").isDisplayed();

        //11 Select checkboxes
        selectСheckboxes(Elements.WIND);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        assertLog(Regex.WIND_TRUE);

        //11 Select checkboxes
        selectСheckboxes(Elements.WATER);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        assertLog(Regex.WATER_TRUE);

        //13 Select radio
        selectRadio(Metals.SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        assertLog(Regex.METAL_SELEN);

        //15 Select in dropdown
        selectColor(Colors.YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        assertLog(Regex.COLOR_YELLOW);

        //17 Unselect and assert checkboxes
        selectСheckboxes(Elements.WATER);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        assertLog(Regex.WATER_FALSE);

        //17 Unselect and assert checkboxes
        selectСheckboxes(Elements.WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        assertLog(Regex.WIND_FALSE);
    }
}
