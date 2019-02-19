package homework.hw6.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import homework.hw4.DifferentElementsPage;
import homework.hw4.SelenideIndexPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homework.hw3.Html.INDEX_HTML_URL;


public class NavigationStep {

    public static SelenideIndexPage indexPage;
    public static DifferentElementsPage differentElementsPage;

    @Given("^I open EPAM JDI site$")
    public void i_open_EPAM_JDI_site() throws Throwable {
        open(INDEX_HTML_URL.htmlName);
        getWebDriver().manage().window().maximize();

        indexPage = page(SelenideIndexPage.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }
}
