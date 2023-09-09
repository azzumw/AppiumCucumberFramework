package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    private TestUtils testUtils = new TestUtils();
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
                testUtils.log().info("initialising driver");

                switch (globalParams.getPlatformName()){
                    case "Android": driver = new AndroidDriver(new ServerManager().getServer().getUrl(),new CapabilitiesManager().getDesiredCapabilities());
                    break;
                    case "iOS": driver = new IOSDriver(new ServerManager().getServer().getUrl(),new CapabilitiesManager().getDesiredCapabilities());
                    break;
                }

                if(driver == null){
                    throw new Exception("driver still not init");
                }
                this.setDriver(driver);
                testUtils.log().info("Driver init");
            }catch (IOException e){
                e.printStackTrace();
                testUtils.log().fatal("Driver init failure. ABORT!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
