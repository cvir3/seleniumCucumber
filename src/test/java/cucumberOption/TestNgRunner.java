package cucumberOption;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/java/features", dryRun = true,
        glue = "stepDefinations", monochrome = true,tags = "@TestQOPS or @NetBaking",
        plugin = {"pretty", "html:target/cucumber.htm"}) // Plugin for report
public class TestNgRunner extends AbstractTestNGCucumberTests{
}
