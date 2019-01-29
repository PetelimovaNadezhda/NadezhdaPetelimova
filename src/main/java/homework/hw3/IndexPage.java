package homework.hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {
    @FindBy(css = "[id='user-icon']")
    private WebElement userIcon;

    @FindBy(css = "[id='name']")
    private WebElement user;

    @FindBy(css = "[id='password']")
    private WebElement pwd;

    @FindBy(css = "[id='login-button']")
    private WebElement submitButton;

    @FindBy(css = "[id='user-name']")
    private WebElement userName;

    @FindBy(css = "li:nth-child(1)")
    private WebElement menuHome;

    @FindBy(css = "li:nth-child(2)")
    private WebElement menuContact;

    @FindBy(css = "li:nth-child(3)")
    private WebElement menuService;

    @FindBy(css = "nav li:nth-child(4)")
    private WebElement menuMetalsColors;
//    body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(4) > a

    @FindBy(css = "div:nth-child(1) > div > div > span")
    private WebElement imgPractise;

    @FindBy(css = "div:nth-child(2) > div > div > span")
    private WebElement imgCustom;

    @FindBy(css = "div:nth-child(3) > div > div > span")
    private WebElement imgMulti;

    @FindBy(css = "div:nth-child(4) > div > div > span")
    private WebElement imgBase;

    @FindBy(css = "div.main-content > div > div:nth-child(1) > div > span")
    private WebElement textPractice;

    @FindBy(css = "div.main-content > div > div:nth-child(2) > div > span")
    private WebElement textCustom;

    @FindBy(css = "div.main-content > div > div:nth-child(3) > div > span")
    private WebElement textMulti;

    @FindBy(css = "div.main-content > div > div:nth-child(4) > div > span")
    private WebElement textBase;

    private WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String name, String password) {
        userIcon.click();
        user.sendKeys(name);
        pwd.sendKeys(password);
        submitButton.click();
    }

    public void open() {
        driver.get("https://epam.github.io/JDI/");
        driver.manage().window().maximize();
    }

    public void title() {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void userNameAssert(String name) {
        assertEquals(userName.getText(), name);
    }

    public void menuButton() {
        assertEquals(menuHome.getText(), "HOME");
        assertEquals(menuContact.getText(), "CONTACT FORM");
        assertEquals(menuService.getText(), "SERVICE");
        //assertEquals(menuMetalsColors.getText(), "METALS & COLORS");
    }

    public void displayedPicture() {
        assertTrue(imgBase.isDisplayed());
        assertTrue(imgCustom.isDisplayed());
        assertTrue(imgMulti.isDisplayed());
        assertTrue(imgPractise.isDisplayed());
    }

    public void displayedText() {
        assertEquals(textPractice.getText(),
                "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project");
        assertEquals(textCustom.getText(),
                "To be flexible and\n" +
                        "customizable");
        assertEquals(textMulti.getText(),
                "To be multiplatform");
        assertEquals(textBase.getText(),
                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");
    }
}
