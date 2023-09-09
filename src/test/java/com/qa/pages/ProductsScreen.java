package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductsScreen extends ActionMenuBar {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    public static WebElement productScreenTitle;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]")
    public static WebElement prod_1_name;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Price\"])[1]")
    public static WebElement prod_1_price;

    public String getTitle(){
        return getAttribute(productScreenTitle,"text");
    }

    public String getProductName(){
        return getAttribute(prod_1_name,"text");
    }

    public String getPrice(){
        return getAttribute(prod_1_price,"text");
    }

    public ProductDetailsScreen pressProduct(){
        click(prod_1_name);
        return new ProductDetailsScreen();
    }


}
