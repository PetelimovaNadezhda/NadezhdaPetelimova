package homework.hw8;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.PageFactory;
import homework.hw7.JDISite;
import homework.hw7.entities.MetalsColors;
import homework.hw7.enums.Nature;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.Collection;

import static com.epam.jdi.light.logger.LogLevels.INFO;
import static homework.hw7.entities.User.PETER;
import static homework.hw8.MetalsColorsParser.dataMetalsColors;

public class JdiCheckMetalsColorsPage {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        WebSettings.logger.setLogLevel(INFO);
        PageFactory.initElements(JDISite.class);
    }

    @DataProvider
    public Object[][] getData() throws FileNotFoundException {
        Collection<MetalsColors> dataArray = dataMetalsColors();
        Object[][] data = new Object[dataArray.size()][1];
        int index = 0;
        for (MetalsColors el : dataArray)
            data[index++][0] = el;
        return data;
    }

    @Test
    public void metalsColorsPageOpenTestJdi() {
        JDISite.indexPageJdi.open();
        JDISite.indexPageJdi.login(PETER);
        JDISite.indexPageJdi.openMetalsColorsPage();
        JDISite.metalColorsPageJdi.skip();
        Nature.setId();
    }

    @Test(dataProvider = "getData")
    public void metalsColorsPageSubmitTestJdi(MetalsColors dataMetalsColors) {
        JDISite.metalColorsPageJdi.submitForm(dataMetalsColors);
        JDISite.metalColorsPageJdi.cleanUpForm(dataMetalsColors);
        JDISite.metalColorsPageJdi.log(dataMetalsColors);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}