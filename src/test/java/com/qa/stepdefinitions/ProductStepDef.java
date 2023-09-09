package com.qa.stepdefinitions;

import com.qa.pages.LoginScreen;
import com.qa.pages.ProductDetailsScreen;
import com.qa.pages.ProductsScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductStepDef {

    @Given("I am logged in")
    public void iAmLoggedIn() {
        // Write code here that turns the phrase above into concrete actions
        new LoginScreen().loginSuccessful("standard_user","secret_sauce");
    }

    @When("I click on product title {string}")
    public void iClickOnProductTitle(String title) {
        // Write code here that turns the phrase above into concrete actions
        new ProductsScreen().pressProduct();
    }
    @Then("I am navigated to Product Detail page with the same {string}, and price {string} and description {string}")
    public void iAmNavigatedToProductDetailPageWithTheSameAndPriceAndDescription(String title, String price, String desc) {
        String actualTitle = new ProductDetailsScreen().getProductTitle();
        String actualProdDesc = new ProductDetailsScreen().getProductDescription();

        Assert.assertEquals(actualTitle,title);
        Assert.assertEquals(actualProdDesc,desc);

    }

    @Then("The product is listed with title {string} and price {string}")
    public void theProductIsListedWithTitleAndPrice(String title, String price) {
        // Write code here that turns the phrase above into concrete actions
        String resultTitle = new ProductsScreen().getProductName();
        String resultPrice = new ProductsScreen().getPrice();

        Assert.assertEquals(resultTitle,title);
        Assert.assertEquals(resultPrice,price);
    }

}
