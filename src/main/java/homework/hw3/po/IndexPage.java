package homework.hw3.po;

import homework.hw3.enums.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @FindBy(css = ".m-l8")
    private List<WebElement> menuButton;

    @FindBy(css = ".icons-benefit")
    private List<WebElement> imgBenefit;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textImg;

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

    @Step
    public void login(Users user) {
        userIcon.click();
        userLogin.sendKeys(user.login);
        pwd.sendKeys(user.password);
        submitButton.click();
    }

    @Step
    public void open(Html html) {
        driver.get(html.htmlName);
        driver.manage().window().maximize();
    }

    @Step
    public void checkTitleName(TextMain name) {
        assertEquals(driver.getTitle(), name.text);
    }

    @Step
    public void userNameAssert(Users user) {
        assertEquals(userName.getText(), user.name);
    }

    @Step
    public void checkMenuButtonText(MenuButton[] textMenuButton) {
        List<String> listTextImg = menuButton.stream().flatMap((e) -> Arrays.stream(e.getText().split("\\r?\\n"))).collect(Collectors.toList());
        for (MenuButton txt: textMenuButton) {
            assertTrue(listTextImg.contains(txt.buttonName));
        }
    }

    @Step
    public void displayedPicture() {
        for (WebElement element: imgBenefit) {
            assertTrue(element.isDisplayed());
        }
    }

    @Step
    public void displayedText(TextForImg[] textExpectedOnSite) {
        List<String> listTextImg = textImg.stream().map(WebElement::getText).collect(Collectors.toList());
        for (TextForImg txt: textExpectedOnSite) {
            assertTrue(listTextImg.contains(txt.text));
        }
    }

    @Step
    public void displayedMainText(TextMain mainTxtTitle, TextMain mainTxtSubTitle) {
        assertTrue(mainTitle.isDisplayed());
        assertTrue(mainText.isDisplayed());

        assertEquals(mainTitle.getText(), mainTxtTitle.text);
        assertEquals(mainText.getText(), mainTxtSubTitle.text);
    }

    @Step
    public void displayedFrame() {
        assertTrue(frame.isDisplayed());
    }

    @Step
    public void displayedLogo() {
        assertTrue(logo.isDisplayed());
    }

    @Step
    public void displayedLeftSector() {
        assertTrue(leftSector.isDisplayed());
    }

    @Step
    public void displayedTextSubHeader(Html html, TextMain mainSubTxt) {
        assertTrue(subText.isDisplayed());
        assertEquals(subText.getText(), mainSubTxt.text);
        assertEquals(subText.getAttribute("href"), html.htmlName);
    }

    @Step
    public void displayedFooter() {
        assertTrue(footer.isDisplayed());
    }
}
