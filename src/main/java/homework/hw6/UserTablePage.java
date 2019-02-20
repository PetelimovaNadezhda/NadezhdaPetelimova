package homework.hw6;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class UserTablePage {

    @FindBy(css = "input[type=\"checkbox\"]")
    ElementsCollection checkbox;

    @FindBy(css = ".user-descr > span")
    ElementsCollection descriptionText;

    @FindBy(css = "#user-table > tbody > tr > td > img")
    ElementsCollection descriptionImg;

    @FindBy(css = "#user-table > tbody > tr > td > select")
    ElementsCollection dropdown;

    @FindBy(css = "#user-table > tbody > tr > td > a")
    ElementsCollection names;

    @FindBy(css = "#user-table > tbody > tr")
    ElementsCollection table;

    @FindBy(css = ".info-panel-body.info-panel-body-log")
    SelenideElement logs;

    @Step
    public void equalsTable(List<Table> expectedTable) {
        String tableOnSite = table.texts().toString().replaceAll("\n", " ");
        for (Table lineExpected : expectedTable) {
            assertTrue(tableOnSite.contains(lineExpected.getNumber().toString()));
            assertTrue(tableOnSite.contains(lineExpected.getUser()));
            assertTrue(tableOnSite.contains(lineExpected.getDescription()));
        }
    }

    @Step
    public void checkInterfaceDropdown(int size) {
        dropdown.shouldHaveSize(size);
    }

    @Step
    public void checkInterfaceNames(int size) {
        names.shouldHaveSize(size);
    }

    @Step
    public void checkInterfaceImgs(int size) {
        descriptionImg.shouldHaveSize(size);
    }

    @Step
    public void checkInterfaceText(int size) {
        descriptionText.shouldHaveSize(size);
    }

    @Step
    public void checkInterfaceCheckbox(int size) {
        checkbox.shouldHaveSize(size);
    }

    @Step
    public void selectVip(String name) {
        switch (name) {
            case ("Roman"):
                $("#roman").click();
                break;
            case ("Sergey Ivan"):
                $("#ivan").click();
                break;
            case ("Vladzimir"):
                $("#vlad").click();
                break;
            case ("Helen Bennett"):
                $("#helen").click();
                break;
            case ("Yoshi Tannamuri"):
                $("#yoshi").click();
                break;
            case ("Giovanni Rovelli"):
                $("#gio").click();
                break;
        }
    }

    @Step
    public void assertLog(String s) {
        logs.shouldHave(Condition.text(s));
    }

    public void clickDropdown() {
        dropdown.first().click();
    }

    public void checkInterfaceDroplist(List<String> list) {
        String s = dropdown.texts().get(0).replaceAll("\n", " ");
        for (String l : list)
            assertTrue(s.contains(l));
    }
}
