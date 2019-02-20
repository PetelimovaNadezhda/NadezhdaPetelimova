package homework.hw4.po;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework.hw4.enums.Colors;
import homework.hw4.enums.Elements;
import homework.hw4.enums.Metals;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

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
    public void checkSection() {
        section.shouldBe(CollectionCondition.size(2));
    }

    @Step
    public void selectNatureElements(Elements element) {
        elements.findBy(text(element.text)).click();
    }

    @Step
    public void selectMetal(Metals metal) {
        metals.findBy(text(metal.text)).click();
    }

    @Step
    public void selectColor(Colors color) {
        colors.selectOptionContainingText(color.text);
    }

    @Step
    public void assertLog(String str) {
        logs.shouldHave(Condition.text(str));
    }

    @Step
    public void checkInterfaceDifferentPage() {
        elements.shouldHaveSize(4);
        metals.shouldHaveSize(4);
        buttons.shouldHaveSize(2);
        colors.shouldBe(visible);
    }
}