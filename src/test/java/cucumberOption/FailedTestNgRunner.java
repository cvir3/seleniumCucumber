package cucumberOption;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "@target/failed_scenarios.txt",
        glue = "stepDefinitions", monochrome = true, tags="@PlaceOrder or @SearchProduct  ",
        plugin = {
        "pretty", "html:target/cucumber.htm",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    })
public class FailedTestNgRunner extends AbstractTestNGCucumberTests{
    @Override
    @DataProvider(parallel = true)
    public Object [] [] scenarios()
    {
        return super.scenarios();
    }
}
