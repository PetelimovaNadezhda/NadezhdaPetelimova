package homework.hw6.steps;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class NavigationStep {
    private static final String INDEX_PAGE_URL = "https://epam.github.io/JDI/";


    @Given("^I open EPAM JDI site$")
    public void iOpenEpamJdiPage(){
        open(INDEX_PAGE_URL);
    }
}
