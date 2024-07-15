package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pageObject.CheckoutPage;
import utilities.TestContextSetup;

import java.io.IOException;


public class CheckoutPageStepDefinition {

    public CheckoutPage checkoutPage;
    public
    TestContextSetup testContextSetup; // This is global variable
    //This is constructor
    public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }


    @Then("verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_enter_promo(){

        Assert.assertTrue(checkoutPage.VerifyPromoBtn());
        Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
    }

    @Then("^User proceed to Checkout and validate the (.+) items in checkout page$")
    public void user_proceed_to_checkout(String name) {
        checkoutPage.CheckoutItems();

    }


}
