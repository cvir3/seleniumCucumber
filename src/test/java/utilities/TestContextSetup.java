package utilities;

import org.openqa.selenium.WebDriver;
import pageObject.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {
    public WebDriver driver;
    public String landingPageProductName;
    public PageObjectManager pageObjectManager;
    public GenericUtils genericUtils;
    public TestBase testBase;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
        genericUtils = new GenericUtils(testBase.WebDriverManager());
    }
}
