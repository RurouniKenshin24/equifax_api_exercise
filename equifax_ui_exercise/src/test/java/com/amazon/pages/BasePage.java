package com.amazon.pages;

import com.amazon.utilities.BrowserUtil;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    @FindBy(id = "twotabsearchtextbox")
    protected WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    protected WebElement findButton;

    @FindBy(xpath = "//div[@class='s-main-slot s-result-list s-search-results sg-row']/div")
    protected List<WebElement> itemList;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    protected List<WebElement> wholePriceList;

    @FindBy(xpath = "//span[@class='a-price-fraction']")
    protected List<WebElement> decimalPriceList;

    private static String itemPrice;

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void searchItem(String str){
        BrowserUtil.enterText(searchBox, str);
        findButton.click();
    }

    public void selectItem(Integer indexNumber){
        BrowserUtil.clickOnItem(itemList.get(indexNumber));
    }

    public void setPrice(Integer indexNumber){
        String wholePrice = wholePriceList.get(indexNumber - 1).getText();
        String decimalPrice = decimalPriceList.get(indexNumber - 1).getText();

        String price = "$" + wholePrice + "." + decimalPrice;
        itemPrice = price;
    }

    public String getItemPrice(){
        return itemPrice;
    }

}
