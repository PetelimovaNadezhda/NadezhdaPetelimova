package homework.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {
    @FindBy(css = "[id='user-icon']")
    private WebElement userIcon;

    @FindBy(css = "[id='name']")
    private WebElement userLogin;

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

    // TODO In this case it is not make a sense to create a separate element for each benefit
    // TODO Take a look on @FindAll annotation and verify this elements in loop
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
    // !TODO

    @FindBy(css = "[name = 'main-title']")
    private WebElement mainTitle;

    @FindBy(css = ".main-txt")
    private WebElement mainText;

    @FindBy(css = "[id='iframe']")
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

    public void login(Users user) {
        userIcon.click();
        userLogin.sendKeys(user.login);
        pwd.sendKeys(user.password);
        submitButton.click();
    }

    public void open(Html html) {
        driver.get(html.htmlName);
        driver.manage().window().maximize();
    }

    public void checkTitleName(Text name) {
        assertEquals(driver.getTitle(), name.text);
    }

    public void userNameAssert(Users user) {
        assertEquals(userName.getText(), user.name);
    }

    public void checkMenuButtonText() {
        assertEquals(menuHome.getText(), MenuButton.HOME_BUTTON.buttonName);
        assertEquals(menuContact.getText(), MenuButton.CONTACT_FORM_BUTTON.buttonName);
        assertEquals(menuService.getText(), MenuButton.SERVICE_BUTTON.buttonName);
        assertEquals(menuMetalsColors.getText(), MenuButton.METALS_COLORS_BUTTON.buttonName);
    }

    public void displayedPicture() {
        assertTrue(imgBase.isDisplayed());
        assertTrue(imgCustom.isDisplayed());
        assertTrue(imgMulti.isDisplayed());
        assertTrue(imgPractise.isDisplayed());
    }

    // TODO This method should be parametrised by List of Enums
    // TODO Take a look on enum default methods
    public void displayedText() {
        assertEquals(textPractice.getText(), Text.PRACTICES_PICTURE_TEXT.text);
        assertEquals(textCustom.getText(), Text.CUSTOM_PICTURE_TEXT.text);
        assertEquals(textMulti.getText(), Text.MULTI_PICTURE_TEXT.text);
        assertEquals(textBase.getText(), Text.BASE_PICTURE_TEXT.text);
    }

    public void displayedMainText() {
        assertTrue(mainTitle.isDisplayed());
        assertTrue(mainText.isDisplayed());

        assertEquals(mainTitle.getText(), Text.MAIN_TITLE_TEXT.text);
        assertEquals(mainText.getText(), Text.MAIN_SUB_TITLE_TEXT.text);
    }

    public void displayedFrame() {
        assertTrue(frame.isDisplayed());
    }

    public void displayedLogo() {
        assertTrue(logo.isDisplayed());
    }

    public void displayedLeftSector() {
        assertTrue(leftSector.isDisplayed());
    }

    public void displayedTextSubHeader(Html html) {
        assertTrue(subText.isDisplayed());
        assertEquals(subText.getText(), Text.MAIN_SUB_TEXT.text);
        assertEquals(subText.getAttribute("href"), html.htmlName);
    }

    public void displayedFooter() {
        assertTrue(footer.isDisplayed());
    }
}
