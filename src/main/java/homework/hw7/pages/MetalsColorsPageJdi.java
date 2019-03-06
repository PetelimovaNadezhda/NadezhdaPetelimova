package homework.hw7.pages;

import homework.hw7.entities.MetalsColors;
import homework.hw7.forms.MetalsColorsForm;
import com.epam.jdi.light.elements.composite.WebPage;

import static org.testng.Assert.assertEquals;

public class MetalsColorsPageJdi extends WebPage {
    MetalsColorsForm metalsColorsForm;

    public void selectSummary(MetalsColors checkForm) {
        for (String val : checkForm.summary)
            metalsColorsForm.summary.select(val);
    }

    public void selectElements() {
            metalsColorsForm.elements.get(0).click();
            metalsColorsForm.elements.get(3).click();
    }

    public void selectColors(MetalsColors checkForm) {
        metalsColorsForm.colors.select(checkForm.color);
    }

    public void selectMetals(MetalsColors checkForm) {
        metalsColorsForm.metals.select(checkForm.metal);
    }

    public void selectVegetables(MetalsColors checkForm) {
        for (String val : checkForm.vegetables)
            metalsColorsForm.vegetables.select(val);
    }

    public void clickSubmit() {
        metalsColorsForm.submit.click();
    }

    public void log(MetalsColors checkForm) {
        assertEquals(metalsColorsForm.log.getText(), checkForm.logList);
    }
}

