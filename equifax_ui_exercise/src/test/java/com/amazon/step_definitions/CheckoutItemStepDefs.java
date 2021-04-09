package com.amazon.step_definitions;

import com.amazon.pages.CartPage;
import com.amazon.pages.CheckoutPage;
import com.amazon.pages.ItemPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CheckoutItemStepDefs {

    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @And("user clicks on the proceed to checkout button")
    public void user_clicks_on_the_proceed_to_checkout_button() {
        cartPage.clickOnProceedToCheckout();
    }


    @Then("user should be able to see same price in the checkout page")
    public void user_should_be_able_to_see_same_price_in_the_checkout_page() {
        String actualPrice = "$47.49";
        String expectedPrice = cartPage.getItemPrice();

        Assert.assertEquals(expectedPrice,actualPrice);
    }
}
