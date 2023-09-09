package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductDetailsScreen extends ActionMenuBar{
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
    public static WebElement productTitle;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]")
    public static WebElement productDescription;

    @AndroidFindBy(accessibility = "test-BACK TO PRODUCTS")
    public static WebElement backToProductsScreenBackButton;


    public String getProductTitle(){
        return getAttribute(productTitle,"text");
    }

    public String getProductDescription(){
        return getAttribute(productDescription,"text");
    }

    public ProductsScreen pressBackToProductsScreenBtn(){
        click(backToProductsScreenBackButton);
        return new ProductsScreen();
    }
}
