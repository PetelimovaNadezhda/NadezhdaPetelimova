package homework.hw6.po;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework.hw6.Superhero;
import homework.hw6.enums.SuperheroNames;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertEquals;
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
    public void equalsTable(List<Superhero> expectedTable) {
        List<Superhero> collect = table.stream().skip(1).map(e -> new Superhero(
                        e.$("td", 0).getText(),
                        e.$("td a").getText(),
                        e.$("td span").getText().replaceAll("\n", " "))
        ).collect(toList());

       assertEquals(expectedTable, collect);
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
        SuperheroNames user = SuperheroNames.getUsersTable(name);
        $("#"+ user.id).click();
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
