package stepDefinitions;

import io.cucumber.java.After;
import utilities.TestContextSetup;

import java.io.IOException;

public class Hooks {
    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @After
    public void AfterSecnario() throws IOException{
        testContextSetup.testBase.WebDriverManager().quit();
    }
}
