import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SimpleTest {

    @Test
    public void simpleTest(){
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://epam.github.io/JDI/index.html");

        assertEquals(driver.getTitle(), "Home Page");

        driver.close();
    }

}
