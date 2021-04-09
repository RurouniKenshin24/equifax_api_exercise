package com.amazon.step_definitions;

import com.amazon.pages.BasePage;
import com.amazon.pages.ItemPage;
import com.amazon.utilities.BrowserUtil;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SearchItemStepDefs {
    ItemPage itemPage = new ItemPage();

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        String amazonURL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(amazonURL);
    }

    @When("user search {string} by using search box")
    public void user_search_by_using_search_box(String string) {
        itemPage.searchItem(string);
    }

    @When("user clicks on the \"{int}\"st item on the listed items")
    public void user_clicks_on_the_st_item_on_the_listed_items(Integer int1) {
        itemPage.setPrice(int1);
        itemPage.selectItem(int1);
    }

    @Then("user should be able to see same price in the item page")
    public void user_should_be_able_to_see_same_price() {
        String actualPrice = itemPage.getPrice();
        String expectedPrice = itemPage.getItemPrice();

        Assert.assertEquals(expectedPrice,actualPrice);
    }

    @Then("user should be able to see title as a {string}")
    public void user_should_be_able_to_see_title_as_a(String string) {
        String actualTitle = BrowserUtil.getTitle();
        String expectedTitle = string;
        String errorMessage = "Title does not equal to " + string + "!!!";

        Assert.assertEquals(expectedTitle,actualTitle,errorMessage);
    }
}
