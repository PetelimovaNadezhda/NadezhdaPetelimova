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

        // TODO This page should be opened via UI, rather than directly.
        JDISite.indexPageJdi.openMetalsColorsPage();

        // TODO Basically, you should have only one single method, that can be used for form filling/submitting.
        // TODO For example, Site.page.form.submit(entity). Entity should have all necessary information.
        JDISite.metalColorsPageJdi.select(checkForm);
        // !TODO

        // TODO This method should get exactly the same entity tha has used for form filling.
        JDISite.metalColorsPageJdi.log(checkForm);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}