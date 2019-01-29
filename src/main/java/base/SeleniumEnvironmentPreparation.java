package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static java.lang.System.setProperty;

public class SeleniumEnvironmentPreparation {
    public WebDriver driver;

    @BeforeSuite
    public  void beforeSuite(){
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    @AfterSuite
    public void afterMethod(){
        driver.close();
    }
}

