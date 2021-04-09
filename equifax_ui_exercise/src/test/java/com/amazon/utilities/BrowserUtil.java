package com.amazon.utilities;

import org.openqa.selenium.WebElement;

public class BrowserUtil {

    public static void clickOnItem(WebElement item){
        item.click();
    }

    public static void enterText(WebElement element, String str){
        element.sendKeys(str);
    }

    public static String getTitle(){
        return Driver.getDriver().getTitle();
    }


}
