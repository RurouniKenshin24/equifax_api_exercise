package com.amazon.step_definitions;

import com.amazon.pages.CartPage;
import com.amazon.pages.ItemPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddItemStepDefs {
    ItemPage itemPage = new ItemPage();
    CartPage cartPage = new CartPage();

    @When("user clicks on the add to cart button")
    public void user_clicks_on_the_add_to_cart_button() {
        itemPage.clickOnAddToCartButton();
    }

    @Then("user should be able to see same price in the cart page")
    public void user_should_be_able_to_see_same_price_in_the_cart_page() {
        String actualPrice = cartPage.getPrice();
        String expectedPrice = cartPage.getItemPrice();

        Assert.assertEquals(expectedPrice,actualPrice);
    }
}
