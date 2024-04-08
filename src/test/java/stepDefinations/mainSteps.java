package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class mainSteps {
    @Given("User is on NetBanking landing page")
    public void user_is_on_net_banking_landing_page() {
        System.out.println("User landed on netbanking page");
    }
    @When("User login into application")
    public void user_login_into_application() {
        System.out.println("Home Page is displayed");
    }
    @Then("Home Page is displayed")
    public void home_page_is_displayed() {
        System.out.println("Home Page is displayed");
    }
    @Then("Cards are displayed")
    public void cards_are_displayed() {
        System.out.println("Cards are displayed");
    }
}
