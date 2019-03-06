package homework.hw8.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Text;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import homework.hw8.entities.MetalsColors;

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
}
