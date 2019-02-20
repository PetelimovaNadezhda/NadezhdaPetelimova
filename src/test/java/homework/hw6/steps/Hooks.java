package homework.hw6.steps;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Hooks {

    @Before()
    public void driverSetUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
    }

    @After
    public void deleteCoookie() {
        getWebDriver().manage().deleteAllCookies();
    }
}
