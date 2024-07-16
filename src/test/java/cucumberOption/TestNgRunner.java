package cucumberOption;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/features",
        glue = "stepDefinitions", monochrome = true, tags="@PlaceOrder or @SearchProduct  ",
        plugin = {"pretty", "html:target/cucumber.htm",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}) // Plugin for report
public class TestNgRunner extends AbstractTestNGCucumberTests{
    @Override
    @DataProvider(parallel = true)
    public Object [] [] scenarios()
    {
        return super.scenarios();
    }
}
