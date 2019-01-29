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
// TODO Scr files should be in root folder of repository.
// TODO .gitignore file can be improved.
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

        // TODO You should ever never developed locators in this way.
        //7 Assert that there are 4 images on the Index Page and they are displayed
       indexPage.displayedPicture();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
       indexPage.displayedText();

        //9 Assert a text of the main headers
        assertTrue(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/h3[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/p")).isDisplayed());

        assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/h3[1]")).getText(),
                "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/p")).getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().window(driver.getWindowHandle());

        //13 Assert a text of the sub header
        assertTrue(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/h3[2]/a")).isDisplayed());
        assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/h3[2]/a")).getText(),
                "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/h3[2]/a")).getAttribute("href"),
                "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector("[id='mCSB_1']")).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(driver.findElement(By.xpath("html/body/footer/div/div")).isDisplayed());
    }
}
