package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObject.LandingPage;
import pageObject.OffersPage;
import utilities.TestContextSetup;

public class OfferPageStepDefinitions {
    public String offerPageProductName;
    TestContextSetup testContextSetup;

    public OfferPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("User searched for {string} shortname in offer page")
    public void user_searched_for_same_shortname_in_offer_page(String shortname) throws InterruptedException {
        switchToOfferPage();
        OffersPage offersPage = new OffersPage(testContextSetup.pageObjectManager.driver);
        offersPage.searchItem(shortname);
        Thread.sleep(3000);
        offerPageProductName = offersPage.getProductName();
        System.out.println(offerPageProductName + "Is extracted from the home page ");
    }

    public void switchToOfferPage() {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDeals();
        testContextSetup.genericUtils.SwitchWindowsToChild();
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_Offers_page() throws InterruptedException {
        Assert.assertEquals(testContextSetup.landingPageProductName, offerPageProductName);
    }
}
