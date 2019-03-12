package homework.hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import homework.hw7.entities.MetalsColors;
import homework.hw7.forms.MetalsColorsForm;

import static org.testng.Assert.assertEquals;

public class MetalsColorsPageJdi extends WebPage {
    MetalsColorsForm metalsColorsForm;

    public void submitForm(MetalsColors metalsColors) {
        metalsColorsForm.submit(metalsColors);
    }


    public void cleanUpForm(MetalsColors metalsColors) {
        metalsColorsForm.clean(metalsColors);
    }

    public void log(MetalsColors metalsColors) {
        assertEquals(
                metalsColorsForm.log.getText(),
                metalsColors.asLogString());
    }

    public void skip() {
        metalsColorsForm.vegetables.select("Vegetables");
    }
}
