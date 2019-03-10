package homework.hw7;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.PageFactory;
import homework.hw7.enums.Nature;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static homework.hw7.entities.MetalsColors.*;
import static homework.hw7.entities.User.PETER;
import static com.epam.jdi.light.logger.LogLevels.INFO;

public class JdiCheckMetalsColorsPage {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        WebSettings.logger.setLogLevel(INFO);
        PageFactory.initElements(JDISite.class);
    }

    @Test
    public void metalsColorsPageTestJdi() {
        JDISite.indexPageJdi.open();
        JDISite.indexPageJdi.login(PETER);
        JDISite.indexPageJdi.openMetalsColorsPage();
        JDISite.metalColorsPageJdi.skip();
        Nature.setId();
        JDISite.metalColorsPageJdi.submitForm(checkForm);
        JDISite.metalColorsPageJdi.log(checkForm);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}