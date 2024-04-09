package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class greenCartDefinations {
    WebDriver driver;
    String landingProductName; // Public
    String OfferPageProductName; // Public

    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

    }

    @When("User searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
        Thread.sleep(3000);
        landingProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(landingProductName + "Is extracted from the home page ");
        // Store landingProductName for print, Split method is return to the array and Trim method using for all remove spaces

    }

    @Then("User searched for {string} shortname in offer page")
    public void user_searched_for_same_shortname_in_offer_page(String shortname) throws InterruptedException {
        driver.findElement(By.linkText("Top Deals")).click();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.id("search-field")).sendKeys(shortname);
        Thread.sleep(3000);
        OfferPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
        System.out.println(OfferPageProductName + "Is extracted from the home page ");
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_Landing_Page() throws InterruptedException {
        Assert.assertEquals(landingProductName, OfferPageProductName);
        Thread.sleep(2000);
        driver.quit();
    }
}
