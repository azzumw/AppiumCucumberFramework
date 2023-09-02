package com.qa.runners.pages;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.PropertyManager;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class BasePage {
    private AppiumDriver driver;

    public BasePage(){
        driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT_TEN_SEC));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT_TEN_SEC));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void clear(WebElement element){
        waitForVisibility(element);
        element.clear();
    }

    public void sendKeys(WebElement element,String text){
        waitForVisibility(element);
        element.sendKeys(text);
    }

    public void sendKeys(WebElement element,String text,String message){
        waitForVisibility(element);
        TestUtils.log().info(message);
        element.sendKeys(text);
    }

    public String getAttribute(WebElement element, String attribute) {
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }

    public String getAttribute(By element, String attribute) {
        waitForVisibility(element);
        return driver.findElement(element).getAttribute(attribute);
    }

    public String getText(WebElement element,String msg){
        String txt;
        switch (new GlobalParams().getPlatformName()){
            case "Android":
                txt = getAttribute(element,"text");break;
            case "iOS":
                txt = getAttribute(element,"label");break;
            default:
                throw new IllegalStateException("Unexpected value: " + new GlobalParams().getPlatformName());
        }
        return txt;
    }
    public String getText(By element,String msg){
        String txt;
        switch (new GlobalParams().getPlatformName()){
            case "Android":
                txt = getAttribute(element,"text");break;
            case "iOS":
                txt = getAttribute(element,"label");break;
            default:
                throw new IllegalStateException("Unexpected value: " + new GlobalParams().getPlatformName());
        }
        return txt;
    }

    public WebElement andScrollToElementUsingUiScrollable(String childLocAttr,String childLocValue){
        return null;
    }

    public  void activateApp() throws IOException {
        ((InteractsWithApps)driver).activateApp(new PropertyManager().getProperties().getProperty("androidAppPackage"));
    }

    public  void terminateApp() throws IOException {
        ((InteractsWithApps)driver).terminateApp(new PropertyManager().getProperties().getProperty("androidAppPackage"));
    }
}
