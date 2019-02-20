package homework.hw6.steps;

import cucumber.api.java.en.Given;
import homework.hw4.DifferentElementsPage;
import homework.hw4.SelenideIndexPage;
import homework.hw6.UserTablePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homework.hw3.Html.INDEX_HTML_URL;


public class NavigationStep {

    public static SelenideIndexPage indexPage;
    public static DifferentElementsPage differentElementsPage;
    public static UserTablePage userTablePage;

    @Given("^I am on Home Page$")
    public void i_open_EPAM_JDI_site() {
        open(INDEX_HTML_URL.htmlName);
        getWebDriver().manage().window().maximize();
        indexPage = page(SelenideIndexPage.class);
        differentElementsPage = page(DifferentElementsPage.class);
        userTablePage = page(UserTablePage.class);
    }
}
