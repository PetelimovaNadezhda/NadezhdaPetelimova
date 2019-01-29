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

    @FindBy(css = ".m-l8 > li:nth-child(1)")
    private WebElement menuHome;

    @FindBy(css = ".m-l8  > li:nth-child(2)")
    private WebElement menuContact;

    @FindBy(css = ".m-l8 >  li:nth-child(3)")
    private WebElement menuService;

    @FindBy(css = ".m-l8 >  li:nth-child(4) > a")
    private WebElement menuMetalsColors;

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

    @FindBy(css = ".main-title")
    private WebElement mainTitle;

    @FindBy(css = ".main-txt")
    private WebElement mainText;

    @FindBy(css ="[id='iframe']")
    private WebElement frame;

    @FindBy(css = "[id='epam_logo']")
    private WebElement logo;

    @FindBy(css = "h3:nth-child(3) > a")
    private WebElement subText;

    @FindBy(css = "[id='mCSB_1']")
    private WebElement leftSector;

    @FindBy(css = ".footer-bg")
    private WebElement footer;

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
        assertEquals(menuMetalsColors.getText(), "METALS & COLORS");
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

    public void displayedMainText(){
        assertTrue(mainTitle.isDisplayed());
        assertTrue(mainText.isDisplayed());

        assertEquals(mainTitle.getText(),
                "EPAM FRAMEWORK WISHES…");
        assertEquals(mainText.getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

    }

    public void displayedFrame(){
        assertTrue(frame.isDisplayed());
    }

    public void displayedLogo() {

        assertTrue(logo.isDisplayed());
    }

    public void displayedLeftSector() {
        assertTrue(leftSector.isDisplayed());
    }

    public void displayedTextSubHeader(){
        assertTrue(subText.isDisplayed());
        assertEquals(subText.getText(),
                "JDI GITHUB");
        assertEquals(subText.getAttribute("href"),
                "https://github.com/epam/JDI");
    }

    public void displayedFooter() {
        assertTrue(footer.isDisplayed());
    }

}
