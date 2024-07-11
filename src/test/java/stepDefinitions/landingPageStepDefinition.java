package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.LandingPage;
import utilities.TestContextSetup;

import java.time.Duration;


public class landingPageStepDefinition {
    TestContextSetup testContextSetup; // This is global variable

    //This is constructor
    public landingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriverManager.chromedriver().setup();
        testContextSetup.driver = new ChromeDriver(chromeOptions);
        testContextSetup.driver.manage().window().maximize();
        testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("User searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
        LandingPage lp = new LandingPage(testContextSetup.driver);
        lp.searchItem(shortname);
        Thread.sleep(3000);
        testContextSetup.landingProductName = lp.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.landingProductName + "Is extracted from the home page ");
        // Store landingProductName for print, Split method is return to the array and Trim method using for all remove spaces
    }
}
