package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


public class ActionMenuBar extends BasePage{
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
    public static WebElement burgerMenuBtn;

    public MenuScreen pressBurgerMenuBtn(){
        click(burgerMenuBtn);
        return new MenuScreen();
    }
}
