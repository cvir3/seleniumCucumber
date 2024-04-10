package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class offerPageStepDefinitions {
    TestContextSetup testContextSetup;

    public offerPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("User searched for {string} shortname in offer page")
    public void user_searched_for_same_shortname_in_offer_page(String shortname) throws InterruptedException {
        testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
        Set<String> s1 = testContextSetup.driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        testContextSetup.driver.switchTo().window(childWindow);
        testContextSetup.driver.findElement(By.id("search-field")).sendKeys(shortname);
        Thread.sleep(3000);
        testContextSetup.OfferPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
        System.out.println(testContextSetup.OfferPageProductName + "Is extracted from the home page ");
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_Landing_Page() throws InterruptedException {
        Assert.assertEquals(testContextSetup.landingProductName, testContextSetup.OfferPageProductName);
        Thread.sleep(2000);
        testContextSetup.driver.quit();
    }
}
