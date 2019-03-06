package homework.hw8.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import homework.hw8.entities.MetalsColors;
import homework.hw8.enums.Nature;
import homework.hw8.forms.MetalsColorsForm;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class MetalsColorsPageJdi extends WebPage {
    MetalsColorsForm metalsColorsForm;

    public void select(MetalsColors checkForm) {
        for (String val : checkForm.summary)
            metalsColorsForm.summary.select(val);

        for (String val : checkForm.element)
            metalsColorsForm.elements.get(Nature.idElement.get(val) - 1).click();

        metalsColorsForm.colors.select(checkForm.color);

        metalsColorsForm.metals.select(checkForm.metal);

        for (String val : checkForm.vegetables)
            metalsColorsForm.vegetables.select(val);

        metalsColorsForm.submit.click();

        for (String val : checkForm.element)
            metalsColorsForm.elements.get(Nature.idElement.get(val) - 1).click();

        for (String val : checkForm.vegetables)
            metalsColorsForm.vegetables.select(val);
    }

    public void log(MetalsColors checkForm) {
        int sum = 0;
        for (String val : checkForm.summary)
            sum += Integer.valueOf(val);

        StringBuilder log = new StringBuilder("Summary: " + sum + "\n" + "Elements: " + Arrays.toString(checkForm.element.toArray()).replaceAll("[\\[\\]]", "") + "\n" + "Color: " + checkForm.color + "\n" + "Metal: " + checkForm.metal + "\n" + "Vegetables: " + Arrays.toString(checkForm.vegetables.toArray()).replaceAll("[\\[\\]]", ""));
        assertEquals(metalsColorsForm.log.getText(), log.toString());
    }

    public void skip() {
        metalsColorsForm.vegetables.select("Vegetables");
    }
}

