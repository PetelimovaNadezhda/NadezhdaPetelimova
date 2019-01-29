package js;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HelpWithJS{
    WebDriver driver;

    public void deleteElement() {
        JavascriptExecutor js;
        if (driver instanceof JavascriptExecutor) {
            js = (JavascriptExecutor) driver;
            js.executeScript(" function getElementByXpath(path) {\n" +
                    "        return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;\n" +
                    "}\n" +
                    "\n" +
                    "        getElementByXpath(\"//html/body/div/div[2]/main/div[2]/div/div[1]/div/div/span\").remove();");
        }
    }
}
