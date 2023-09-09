package com.qa.stepdefinitions;

import com.qa.pages.LoginScreen;
import com.qa.pages.ProductsScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {

    @Given("I enter the username as {string}")
    public void iEnterTheUsernameAs(String username) {
        new LoginScreen().enterUsername(username);

    }
    @Given("I enter the password as {string}")
    public void iEnterThePasswordAs(String password) {
        // Write code here that turns the phrase above into concrete actions
        new LoginScreen().enterPassword(password);
    }
    @When("I press the login button")
    public void iPressTheLoginButton() {
        // Write code here that turns the phrase above into concrete actions
       new LoginScreen().pressLoginButton();
    }

    @Then("Login should fail with the error {string}")
    public void loginShouldFailWithTheError(String errorMessage) {
        // Write code here that turns the phrase above into concrete actions
        String actualError = new LoginScreen().getError();
        Assert.assertEquals(errorMessage,actualError);
    }

    @Then("I should see products page with title {string}")
    public void iShouldSeeProductsPageWithTitle(String productTScreenTitle) {
        // Write code here that turns the phrase above into concrete actions
        String resultText = new ProductsScreen().getTitle();
        Assert.assertEquals(resultText,productTScreenTitle);
    }

}
