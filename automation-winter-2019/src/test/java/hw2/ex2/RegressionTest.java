package hw2.ex2;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegressionTest extends SeleniumBase {


    @Test(groups = "regression")
    public void testEpamJdiPage1() {
        //0 Test structure
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.cssSelector("[id='user-name']")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper text
        assertEquals(driver.findElement(By.xpath("//a[@href='index.html']")).getText(), "HOME");
        assertEquals(driver.findElement(By.xpath("//a[@href='contacts.html']")).getText(), "CONTACT FORM");
        assertEquals(driver.findElement(By.xpath("html/body/header/div/nav/ul[1]/li[3]/a")).getText(), "SERVICE");
        assertEquals(driver.findElement(By.xpath("//a[@href='metals-colors.html']")).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[1]/div/div/span"))
                .isDisplayed());
        assertTrue(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[2]/div/div/span"))
                .isDisplayed());
        assertTrue(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[3]/div/div/span"))
                .isDisplayed());
        assertTrue(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[4]/div/div/span"))
                .isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[1]/div/span")).getText(),
                "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project");
        assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[2]/div/span")).getText(),
                "To be flexible and\n" +
                        "customizable");
        assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[3]/div/span")).getText(),
                "To be multiplatform");
        assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[4]/div/span")).getText(),
                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");

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

        //17 Close Browser
        driver.close();
    }

    @Test(groups = "regression")
    public void testEpamJdiPage2() {
        //0 Test structure
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.cssSelector("[id='user-name']")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper text
        assertEquals(driver.findElement(By.xpath("//a[@href='index.html']")).getText(), "HOME");
        assertEquals(driver.findElement(By.xpath("//a[@href='contacts.html']")).getText(), "CONTACT FORM");
        assertEquals(driver.findElement(By.xpath("html/body/header/div/nav/ul[1]/li[3]/a")).getText(), "SERVICE");
        assertEquals(driver.findElement(By.xpath("//a[@href='metals-colors.html']")).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[1]/div/div/span"))
                .isDisplayed());
        assertTrue(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[2]/div/div/span"))
                .isDisplayed());
        assertTrue(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[3]/div/div/span"))
                .isDisplayed());
        assertTrue(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[4]/div/div/span"))
                .isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[1]/div/span")).getText(),
                "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project");
        assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[2]/div/span")).getText(),
                "To be flexible and\n" +
                        "customizable");
        assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[3]/div/span")).getText(),
                "To be multiplatform");
        assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[4]/div/span")).getText(),
                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");

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

        //17 Close Browser
        driver.close();
    }

    @Test(groups = "regression")
    public void testEpamJdiPage3() {
        //0 Test structure
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.cssSelector("[id='user-name']")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper text
        assertEquals(driver.findElement(By.xpath("//a[@href='index.html']")).getText(), "HOME");
        assertEquals(driver.findElement(By.xpath("//a[@href='contacts.html']")).getText(), "CONTACT FORM");
        assertEquals(driver.findElement(By.xpath("html/body/header/div/nav/ul[1]/li[3]/a")).getText(), "SERVICE");
        assertEquals(driver.findElement(By.xpath("//a[@href='metals-colors.html']")).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[1]/div/div/span"))
                .isDisplayed());
        assertTrue(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[2]/div/div/span"))
                .isDisplayed());
        assertTrue(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[3]/div/div/span"))
                .isDisplayed());
        assertTrue(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[4]/div/div/span"))
                .isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[1]/div/span")).getText(),
                "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project");
        assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[2]/div/span")).getText(),
                "To be flexible and\n" +
                        "customizable");
        assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[3]/div/span")).getText(),
                "To be multiplatform");
        assertEquals(driver.findElement(By.xpath("html/body/div/div[2]/main/div[2]/div/div[4]/div/span")).getText(),
                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");

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

        //17 Close Browser
        driver.close();
    }
}
