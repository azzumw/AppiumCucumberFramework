package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MenuScreen extends BasePage{

    @AndroidFindBy(accessibility = "test-LOGOUT")
    public static WebElement LOGOUT;

    public LoginScreen clickLogout(){
        click(LOGOUT);
        return new LoginScreen();
    }
}
