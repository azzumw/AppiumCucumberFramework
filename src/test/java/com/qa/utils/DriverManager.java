package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.And;

import java.io.IOException;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public AppiumDriver getDriver(){
        return  driver.get();
    }

    public void setDriver(AppiumDriver driver1){
        driver.set(driver1);
    }

    public void initDriver(){
        AppiumDriver driver = null;
        GlobalParams globalParams = new GlobalParams();
        PropertyManager propertyManager = new PropertyManager();

        if(driver == null){
            try {
                TestUtils.log().info("initialising driver");

                switch (globalParams.getPlatformName()){
                    case "Android": new AndroidDriver(new ServerManager().getServer().getUrl(),new CapabilitiesManager().getDesiredCapabilities());
                    break;
                    case "iOS": new IOSDriver(new ServerManager().getServer().getUrl(),new CapabilitiesManager().getDesiredCapabilities());
                    break;
                }

                if(driver == null){
                    throw new Exception("driver still not init");
                }
                this.setDriver(driver);
                TestUtils.log().info("Driver init");
            }catch (IOException e){
                e.printStackTrace();
                TestUtils.log().fatal("Driver init failure. ABORT!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
