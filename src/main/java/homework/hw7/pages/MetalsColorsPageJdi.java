package homework.hw7.pages;

import homework.hw7.entities.MetalsColors;
import homework.hw7.forms.MetalsColorsForm;
import com.epam.jdi.light.elements.composite.WebPage;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class MetalsColorsPageJdi extends WebPage {
    MetalsColorsForm metalsColorsForm;

    public void submitForm(MetalsColors metalsColors) {
        metalsColorsForm.submit(metalsColors);
    }

    public void log(MetalsColors metalsColors) {
        int sum = 0;
        for (String val : metalsColors.summary)
            sum += Integer.valueOf(val);


        // TODO So complicated, it will be better with List<String>
        // TODO TODO Besides, you can override toString method for  MetalsColors class...
        String log = "Summary: " + sum + "\n"
                + "Elements: " + Arrays.toString(metalsColors.element.toArray()).replaceAll("[\\[\\]]", "") + "\n"
                + "Color: " + metalsColors.color + "\n" + "Metal: " + metalsColors.metal + "\n"
                + "Vegetables: " + Arrays.toString(metalsColors.vegetables.subList(1, 3).toArray()).replaceAll("[\\[\\]]", "");

        assertEquals(metalsColorsForm.log.getText(), log);
    }
}

