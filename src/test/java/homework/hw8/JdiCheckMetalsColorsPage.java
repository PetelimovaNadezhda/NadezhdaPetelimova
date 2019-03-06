package homework.hw8;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.PageFactory;
import homework.hw8.entities.MetalsColors;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.logger.LogLevels.INFO;
import static homework.hw8.entities.User.PETER;

public class JdiCheckMetalsColorsPage {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        WebSettings.logger.setLogLevel(INFO);
        PageFactory.initElements(JDISite.class);
    }

    @Test
    public void tableTestJdi() {
        JDISite.indexPageJdi.open();
        JDISite.indexPageJdi.login(PETER);

        JDISite.indexPageJdi.openMetalsColorsPage();

        JDISite.metalColorsPageJdi.skip();
        for (MetalsColors data : MetalsColorsParser.dataMetalsColors()) {
            JDISite.metalColorsPageJdi.select(data);
            JDISite.metalColorsPageJdi.log(data);
        }
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}