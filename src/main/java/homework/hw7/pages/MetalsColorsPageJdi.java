package homework.hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import homework.hw7.entities.MetalsColors;
import homework.hw7.forms.MetalsColorsForm;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class MetalsColorsPageJdi extends WebPage {
    MetalsColorsForm metalsColorsForm;

    public void submitForm(MetalsColors metalsColors) {
        metalsColorsForm.submit(metalsColors);
    }

    public void log(MetalsColors metalsColors) {
        int sum = 0;
        for (Integer val : metalsColors.summary)
            sum += val;

        // TODO So complicated, it will be better with List<String>
        // TODO Besides, you can override toString method for  MetalsColors class...
        List<String> logs = new ArrayList<>();
        logs.add("Summary: ");
        logs.add(Integer.toString(sum));
        logs.add("\nElements: ");
        logs.add(String.join(", ", metalsColors.elements));
        logs.add("\nColor: ");
        logs.add(metalsColors.color);
        logs.add("\nMetal: ");
        logs.add(metalsColors.metals);
        logs.add("\nVegetables: ");
        logs.add(String.join(", ", metalsColors.vegetables));

        assertEquals(metalsColorsForm.log.getText(), String.join("", logs));
    }

    public void skip() {
        metalsColorsForm.vegetables.select("Vegetables");
    }
}
