package homework.hw6;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import homework.hw4.DifferentElementsPage;
import homework.hw4.SelenideIndexPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@CucumberOptions(
        features = "classpath:homework6",
        glue = "classpath:homework6.steps")
public class RunAcceptianceIT extends AbstractTestNGCucumberTests {

    @BeforeSuite()
    public void driverSetUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
        PageFactory.initElements(getWebDriver(), DifferentElementsPage.class);
        PageFactory.initElements(getWebDriver(), SelenideIndexPage.class);
    }
}
