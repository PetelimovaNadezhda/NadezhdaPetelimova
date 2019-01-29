package homework.hw3;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EpamSiteTest extends SeleniumBase {
    private IndexPage indexPage;
    private WebDriver driver;

    @BeforeMethod
    public void initTest() {
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @AfterMethod
    public void closeTest() {
        driver.close();
    }

    @Test
    public void testEpamJdiPage() {
        //1 Open test site by URL
        indexPage.open();

        //2 Assert Browser title
        indexPage.title();

        //3 Perform login
        indexPage.login("epam", "1234");

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.userNameAssert("PITER CHAILOVSKII");

        //5 Assert Browser title
        indexPage.title();

        //6 Assert that there are 4 items on the header section are displayed and they have proper text
        indexPage.menuButton();

        //7 Assert that there are 4 images on the Index Page and they are displayed
       indexPage.displayedPicture();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
       indexPage.displayedText();

        //9 Assert a text of the main headers
        indexPage.displayedMainText();

        //10 Assert that there is the iframe in the center of page
        indexPage.displayedFrame();

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        indexPage.displayedLogo();

        //12 Switch to original window back
        driver.switchTo().window(driver.getWindowHandle());

        //13 Assert a text of the sub header
        //14 Assert that JDI GITHUB is a link and has a proper URL
        indexPage.displayedTextSubHeader();

        //15 Assert that there is Left Section
        indexPage.displayedLeftSector();

        //16 Assert that there is Footer
        indexPage.displayedFooter();
    }
}
