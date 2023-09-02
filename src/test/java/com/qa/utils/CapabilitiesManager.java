package com.qa.utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {

    private static String getAPKPath(String apkName) {

        String rootDir =  System.getProperty("user.dir");
        String apk_Dir = ("/src/test/resources/apps/"+apkName).replace('/', File.separatorChar);
        return rootDir + apk_Dir;
    }

    public DesiredCapabilities getDesiredCapabilities() throws IOException {
        TestUtils.log().info("Desired capabilities being set");
        GlobalParams params = new GlobalParams();
        Properties properties = new PropertyManager().getProperties();

        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,params.getPlatformName());
            desiredCapabilities.setCapability(MobileCapabilityType.UDID,params.getUdid());
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,params.getDeviceName());

            if(params.getPlatformName().equals("Android")){
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,properties.getProperty("androidAutomationName"));
                desiredCapabilities.setCapability("appPackage",properties.getProperty("androidAppPackage"));
                desiredCapabilities.setCapability("appActivity",properties.getProperty("androidAppActivity"));
                desiredCapabilities.setCapability("systemPort",params.getSystemPort());
                desiredCapabilities.setCapability("chromeDriverPort",params.getChromeDriverPort());
                desiredCapabilities.setCapability(MobileCapabilityType.APP,getAPKPath(properties.getProperty("androidApk")));

            }else {
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,properties.getProperty("iOSAutomationName"));
                desiredCapabilities.setCapability("bundleId",properties.getProperty("iOSBundleId"));
                desiredCapabilities.setCapability("wdaLocalPort",params.getWdaLocalPort());
                desiredCapabilities.setCapability("webkitDebugProxyPort",params.getWebkitDebugProxyPort());
                desiredCapabilities.setCapability(MobileCapabilityType.APP,getAPKPath("iOSApp"));
            }

            return desiredCapabilities;
        }catch (Exception e){
            e.printStackTrace();
            TestUtils.log().error("DesiredCapabilities issue: " + e.getLocalizedMessage());
            throw e;
        }
    }
}
