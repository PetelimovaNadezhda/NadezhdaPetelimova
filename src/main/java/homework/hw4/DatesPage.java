package homework.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertTrue;

public class DatesPage {
    @FindBy(css = ".info-panel-body.info-panel-body-log")
    SelenideElement logs;
    @FindBy(css = ".ui-slider-handle")
    ElementsCollection leftRange;
    @FindBy(css =  ".ui-slider-handle")
    ElementsCollection rightRange;
    @FindBy(css = ".ui-slider-range")
    SelenideElement sliderRange;

void setRange(int left, int right) {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("arguments[0].style.left='" + left + "%';\n" +
                "arguments[0].childNodes[0].innerHTML='" + left + "';\n", leftRange.first());
        leftRange.first().click();
        js.executeScript("arguments[0].style.left='" + right + "%';\n" +
                "arguments[0].childNodes[0].innerHTML='" + right + "';\n" +
                "arguments[1].style.left='" + left + "%';\n" +
                "arguments[1].style.width='" + (right - left) + "%'", rightRange .last(), sliderRange);
        rightRange .last().click();
    }

    public void assertLogRange(int from, int to) {
        logs.shouldHave(Condition.text("Range 2(From):" + from + " link clicked"));
        logs.shouldHave(Condition.text("Range 2(To):" + to + " link clicked"));
    }
}