package homework.hw6.steps;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homework.hw3.Html.INDEX_HTML_URL;

public class NavigationStep {

    @Given("^I open EPAM JDI site$")
    public void iOpenEpamJdiPage(){
        open(INDEX_HTML_URL.htmlName);
        getWebDriver().manage().window().maximize();
    }
}
