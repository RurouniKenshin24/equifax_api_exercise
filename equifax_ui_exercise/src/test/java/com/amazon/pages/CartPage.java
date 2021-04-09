package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "(//span[@class='a-color-price hlb-price a-inline-block a-text-bold'])[1]")
    private WebElement itemPrice;

    @FindBy(id = "hlb-ptc-btn-native")
    private WebElement proceedToCheckoutButton;

    public String getPrice(){
        return itemPrice.getText();
    }

    public void clickOnProceedToCheckout(){
        proceedToCheckoutButton.click();
    }
}
