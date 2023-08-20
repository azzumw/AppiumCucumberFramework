package com.qa.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

    @Given("I enter the username as {string}")
    public void iEnterTheUsernameAs(String username) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("I enter the password as {string}")
    public void iEnterThePasswordAs(String password) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I press the login button")
    public void iPressTheLoginButton() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Login should fail with the error {string}")
    public void loginShouldFailWithTheError(String errorMessage) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I should see products page with title {string}")
    public void iShouldSeeProductsPageWithTitle(String productTScreenTitle) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
