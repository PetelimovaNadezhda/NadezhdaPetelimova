package homework.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework.hw3.TextMain;
import homework.hw3.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class SelenideIndexPage {
    @FindBy(css = ".dropdown-menu > li")
    ElementsCollection serviceMenuHeaderSubcategory;

    @FindBy(css = ".dropdown-toggle")
    SelenideElement serviceMenuHeader;

    @FindBy(css = "#user-name")
    SelenideElement userName;

    @FindBy(css = ".sub > li")
    ElementsCollection serviceMenuChildrenLeftSection;

    @FindBy(css = ".menu-title")
    SelenideElement serviceMenuLeftSection;

    @FindBy(css = "#user-icon")
    SelenideElement userIcon;

    @FindBy(css = "#name")
    SelenideElement login;

    @FindBy(css = "#password")
    SelenideElement pass;

    @FindBy(css = "#login-button")
    SelenideElement loginButton;

    @FindBy(css = ".benefit-icon")
    ElementsCollection img;

    @FindBy(css = ".benefit")
    ElementsCollection text;

    @Step
    public void login(Users user) {
        userIcon.click();
        login.sendKeys(user.login);
        pass.sendKeys(user.password);
        loginButton.click();
    }

    @Step
    public void userNameAssert(Users user) {
        userName.shouldHave(text(user.name));
    }

    @Step
    public void serviceMenu(ServiceSubcategory[] subcategory) {
        serviceMenuLeftSection.click();
        List<String> enumSubcategory = Stream.of(subcategory)
                .map(e -> e.text)
                .collect(Collectors.toList());
        serviceMenuChildrenLeftSection.first(8).shouldHave(texts(enumSubcategory));
    }

    @Step
    public void serviceMenuHeader(ServiceSubcategory[] subcategory) {
        serviceMenuHeader.click();
        List<String> enumSubcategory = Stream.of(subcategory)
                .map(e -> e.text)
                .map(e -> e.toUpperCase())
                .collect(Collectors.toList());
        serviceMenuHeaderSubcategory.shouldHave(texts(enumSubcategory));
    }

    @Step
    public void checkBrowserTitle(TextMain name) {
        assertEquals(getWebDriver().getTitle(), name.text);
    }

    @Step
    public void openPage(ServiceSubcategory subcategory) {
        serviceMenuHeader.click();
        serviceMenuHeaderSubcategory.findBy(text(subcategory.text)).click();
    }

    @Step
    public void checkInterfaceIndexPage() {
        img.shouldHaveSize(4);
        text.shouldHaveSize(4);
    }
}