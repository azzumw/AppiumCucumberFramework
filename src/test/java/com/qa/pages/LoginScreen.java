package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BasePage {
    @AndroidFindBy(accessibility = "test-Username")
    public static WebElement usernameTextField;

    @AndroidFindBy(accessibility = "test-Password")
    public static WebElement passwordTextField;

    @AndroidFindBy(accessibility = "test-LOGIN")
    public static WebElement loginBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    public static WebElement errorField;


    public ProductsScreen loginSuccessful(String username, String password){
        enterUsername(username);
        enterPassword(password);
        return pressLoginButton();
    }

    public LoginScreen enterUsername(String username){
        clear(usernameTextField);
        sendKeys(usernameTextField,username);
        return this;
    }

    public LoginScreen enterPassword(String password){
        clear(passwordTextField);
        sendKeys(passwordTextField,password);
        return this;
    }

    public ProductsScreen pressLoginButton(){
        click(loginBtn);
        return new ProductsScreen();
    }

    public String getError(){

        return getText(errorField,"error text is - ");
    }
}
