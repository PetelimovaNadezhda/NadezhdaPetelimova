package homework.hw6;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"classpath:hw6"},
        glue = {"homework.hw6.steps"})
public class RunAcceptianceITest extends AbstractTestNGCucumberTests {

}
