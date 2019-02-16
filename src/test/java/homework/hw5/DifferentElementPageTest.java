package homework.hw5;

import base.SelenideBase;
import com.codeborne.selenide.WebDriverRunner;
import homework.hw3.TextMain;
import homework.hw3.Users;

import homework.hw4.DifferentElementsPage;
import homework.hw4.SelenideIndexPage;
import homework.hw4.ServiceSubcategory;
import io.qameta.allure.Attachment;
import io.qameta.allure.Story;
import io.qameta.allure.Feature;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homework.hw3.Html.INDEX_HTML_URL;
import static homework.hw4.BooleanLiterals.FALSE;
import static homework.hw4.BooleanLiterals.TRUE;
import static homework.hw4.Colors.YELLOW;
import static homework.hw4.ElementTypes.COLORS;
import static homework.hw4.ElementTypes.METAL;
import static homework.hw4.Elements.WATER;
import static homework.hw4.Elements.WIND;
import static homework.hw4.LogPatterns.ELEMENTS;
import static homework.hw4.LogPatterns.METAL_COLOR;
import static homework.hw4.Metals.SELEN;
import static homework.hw4.ServiceSubcategory.DIFFERENT;

public class DifferentElementPageTest extends SelenideBase implements ITestListener {
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
    @Story(value = "Interface")
    @Test
    public void testEpamJdiPage5() {
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
        differentElementsPage.assertLog(String.format(ELEMENTS.patterns, WIND.text, FALSE.text));

        //11 Select checkboxes
        differentElementsPage.selectCheckboxes(WATER);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.assertLog(String.format(ELEMENTS.patterns, WATER.text, TRUE.text));

        //13 Select radio
        differentElementsPage.selectRadio(SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.assertLog(String.format(METAL_COLOR.patterns, METAL.text, SELEN.text));

        //15 Select in dropdown
        differentElementsPage.selectColor(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        differentElementsPage.assertLog(String.format(METAL_COLOR.patterns, COLORS.text, YELLOW.text));

        //17 Unselect and assert checkboxes
        differentElementsPage.selectCheckboxes(WATER);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.assertLog(String.format(ELEMENTS.patterns, WATER.text, FALSE.text));

        //17 Unselect and assert checkboxes
        differentElementsPage.selectCheckboxes(WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.assertLog(String.format(ELEMENTS.patterns, WIND.text, FALSE.text));
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        makeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
