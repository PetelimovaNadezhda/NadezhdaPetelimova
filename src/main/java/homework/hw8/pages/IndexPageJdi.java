package homework.hw8.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;
import homework.hw8.entities.User;
import homework.hw8.forms.LoginForm;
import org.openqa.selenium.support.FindBy;

public class IndexPageJdi extends WebPage {
    LoginForm loginForm;

    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;

    @FindBy(css = ".m-l8 > li > a")
    WebList metalsColorsPageButton;

    public void login(User user) {
        loginIcon.click();
        loginForm.login(user);
    }

    public void openMetalsColorsPage(){
        metalsColorsPageButton.last().click();
    }
}