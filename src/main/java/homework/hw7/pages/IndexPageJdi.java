package homework.hw7.pages;

import com.codeborne.selenide.ElementsCollection;
import com.epam.jdi.light.elements.complex.WebList;
import homework.hw7.entities.User;
import homework.hw7.forms.LoginForm;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;
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