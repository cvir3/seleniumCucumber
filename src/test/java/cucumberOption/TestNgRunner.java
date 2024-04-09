package cucumberOption;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/java/features",
        glue = "stepDefinations", monochrome = true,
        plugin = {"pretty", "html:target/cucumber.htm"}) // Plugin for report
public class TestNgRunner extends AbstractTestNGCucumberTests{
}
