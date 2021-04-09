package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage{

    @FindBy(id = "productTitle")
    private WebElement searchedItem;

    @FindBy(id = "newBuyBoxPrice")
    private WebElement itemPrice;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    public String getPrice(){
        return itemPrice.getText();
    }

    public void clickOnAddToCartButton(){
        addToCartButton.click();
    }
}
