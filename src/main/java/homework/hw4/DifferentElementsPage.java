package homework.hw4;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.sun.javafx.binding.StringFormatter;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPage {
    @FindBy(css = ".info-panel-body.info-panel-body-log")
    SelenideElement logs;

    @FindBy(css = ".main-content-hg >.checkbox-row > .label-checkbox")
    ElementsCollection elements;

    @FindBy(css = ".main-content-hg >.checkbox-row > .label-radio")
    ElementsCollection metals;

    @FindBy(css = ".main-content-hg > .colors > .uui-form-element")
    SelenideElement colors;

    @FindBy(css = ".main-content-hg > .uui-button")
    ElementsCollection buttons;

    @FindBy(css = ".uui-side-bar")
    ElementsCollection section;

    @Step
    void checkSection() {
        section.shouldBe(CollectionCondition.size(2));
    }

    @Step
    void selectCheckboxes(Elements element) {
        elements.findBy(text(element.text)).click();
    }

    @Step
    void selectRadio(Metals metal) {
        metals.findBy(text(metal.text)).click();
    }

    @Step
    void selectColor(Colors color) {
        colors.selectOptionContainingText(color.text);
    }

    @Step
    void assertLog(String str) {
        logs.shouldHave(Condition.text(str));
    }

    @Step
    void checkInterface() {
        elements.shouldHaveSize(4);
        metals.shouldHaveSize(4);
        buttons.shouldHaveSize(2);
        colors.shouldBe(visible);
    }
}