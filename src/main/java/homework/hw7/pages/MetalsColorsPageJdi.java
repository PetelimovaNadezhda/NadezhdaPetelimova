package homework.hw7.pages;

import homework.hw7.entities.MetalsColors;
import homework.hw7.forms.MetalsColorsForm;
import com.epam.jdi.light.elements.composite.WebPage;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class MetalsColorsPageJdi extends WebPage {
    MetalsColorsForm metalsColorsForm;

    public void select(MetalsColors checkForm) {
        for (String val : checkForm.summary)
            metalsColorsForm.summary.select(val);

        metalsColorsForm.elements.get(0).click();
        metalsColorsForm.elements.get(3).click();

        metalsColorsForm.colors.select(checkForm.color);

        metalsColorsForm.metals.select(checkForm.metal);

        for (String val : checkForm.vegetables)
            metalsColorsForm.vegetables.select(val);

        metalsColorsForm.submit.click();
    }

    public void log(MetalsColors checkForm) {
        int sum = 0;
        for (String val : checkForm.summary)
            sum += Integer.valueOf(val);

        StringBuilder log = new StringBuilder("Summary: " + sum + "\n"+ "Elements: " + Arrays.toString(checkForm.element.toArray()).replaceAll("[\\[\\]]", "") + "\n" + "Color: " + checkForm.color + "\n" + "Metal: " + checkForm.metal + "\n" + "Vegetables: " + Arrays.toString(checkForm.vegetables.subList(1,3).toArray()).replaceAll("[\\[\\]]", ""));
        assertEquals(metalsColorsForm.log.getText(), log.toString());
    }
}

