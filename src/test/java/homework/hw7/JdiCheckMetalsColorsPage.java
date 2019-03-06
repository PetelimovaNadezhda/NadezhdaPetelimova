package homework.hw7;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.PageFactory;
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
    public void tableTestJdi() {
        JDISite.indexPageJdi.open();
        JDISite.indexPageJdi.login(PETER);
        JDISite.metalColorsPageJdi.open();
        JDISite.metalColorsPageJdi.selectSummary(SUMMARY);
        JDISite.metalColorsPageJdi.selectElements();
        JDISite.metalColorsPageJdi.selectColors(COLOR);
        JDISite.metalColorsPageJdi.selectMetals(METAL);
        JDISite.metalColorsPageJdi.selectVegetables(VEGETABLES);
        JDISite.metalColorsPageJdi.clickSubmit();
        JDISite.metalColorsPageJdi.log(LOG);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}