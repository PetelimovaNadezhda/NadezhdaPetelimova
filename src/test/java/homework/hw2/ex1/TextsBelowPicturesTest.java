package homework.hw2.ex1;

import base.SeleniumEnvironmentPreparation;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TextsBelowPicturesTest extends SeleniumEnvironmentPreparation {

    // TODO Could you please create locators by your own instead of copy it from devtool.
    @DataProvider
    private Object[][] textsDataProvider() {
        return new Object[][]{
                {"html/body/div/div[2]/main/div[2]/div/div[1]/div/span",
                        "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"},

                {"html/body/div/div[2]/main/div[2]/div/div[2]/div/span",
                        "To be flexible and\n" +
                        "customizable"},

                {"html/body/div/div[2]/main/div[2]/div/div[3]/div/span",
                        "To be multiplatform"},

                {"html/body/div/div[2]/main/div[2]/div/div[4]/div/span",
                        "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"}

        };
    }

    @Test(dataProvider = "textsDataProvider")
    public void textsBelowPicturesTest(String xpathPic, String text) {
        assertEquals(driver.findElement(By.xpath(xpathPic)).getText(),text);
    }
}
