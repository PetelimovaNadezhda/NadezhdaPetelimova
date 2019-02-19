package homework.hw6.steps;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.java.Before;

public class Hooks{

    @Before()
        public void driverSetUp() {
            Configuration.browser = Browsers.CHROME;
            Configuration.timeout = 5000;
            Configuration.pollingInterval = 300;
        }
}
