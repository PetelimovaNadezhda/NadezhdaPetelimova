package homework.hw7.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Text;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import homework.hw7.entities.MetalsColors;
import homework.hw7.enums.Nature;

public class MetalsColorsForm extends Form<MetalsColors> {

    @FindBy(css = ".info-panel-section")
    public RadioButtons summary;

    @FindBy(css = "#elements-checklist p")
    public WebList elements;

    @JDropdown(root = "#colors", value = ".filter-option",
            list = "li", expand = ".caret")
    public Droplist colors;

    @JDropdown(root = "#metals", value = ".selectpicker",
            list = "li", expand = ".caret")
    public Droplist metals;

    @JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle",
            list = "li", expand = ".caret")
    public Droplist vegetables;

    @FindBy(css = "#submit-button")
    public Button submit;

    @FindBy(css = ".info-panel-body-result")
    public Text log;

    @Override
    public void submit(MetalsColors metalsColors) {
        for (Integer val : metalsColors.summary)
            summary.select(val.toString());

        for (String val : metalsColors.elements)
            elements.get(Nature.idElement.get(val)).click();

        colors.select(metalsColors.color);

        metals.select(metalsColors.metals);

        for (String val : metalsColors.vegetables)
            vegetables.select(val);

        submit.click();
    }

    // TODO This should not me here, take a look on method name
    // TODO If you want to clean up the form, you should create special method.
    public void clean(MetalsColors metalsColors) {
        for (String val : metalsColors.elements)
            elements.get(Nature.idElement.get(val)).click();

        for (String val : metalsColors.vegetables)
            vegetables.select(val);

    }
}
