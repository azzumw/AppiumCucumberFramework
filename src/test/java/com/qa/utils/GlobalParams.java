package com.qa.utils;

public class GlobalParams {

    private static ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static ThreadLocal<String> udid = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
    private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();
    private static ThreadLocal<String> wdaLocalPort = new ThreadLocal<String>();
    private static ThreadLocal<String> webkitDebugProxyPort = new ThreadLocal<String>();

    public String getPlatformName() {
        return platformName.get();
    }

    public void setPlatformName(String platformname) {
        platformName.set(platformname);
    }

    public String getUdid() {
        return udid.get();
    }

    public void setUdid(String pUdid) {
        udid.set(pUdid);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String devicename) {
        deviceName.set(devicename);
    }

    public String getSystemPort() {
        return systemPort.get();
    }

    public void setSystemPort(String systemport) {
        systemPort.set(systemport);
    }

    public String getChromeDriverPort() {
        return chromeDriverPort.get();
    }

    public void setChromeDriverPort(String chromedriverport) {
        chromeDriverPort.set(chromedriverport);
    }

    public String getWdaLocalPort() {
        return wdaLocalPort.get();
    }

    public void setWdaLocalPort(String wdaport) {
        wdaLocalPort.set(wdaport);
    }

    public ThreadLocal<String> getWebkitDebugProxyPort() {
        return webkitDebugProxyPort;
    }

    public void setWebkitDebugProxyPort(String webkitdebugproxyport) {
        webkitDebugProxyPort.set(webkitdebugproxyport);
    }

    public void initializeGlobalParams() {
        GlobalParams params = new GlobalParams();

        params.setPlatformName(System.getProperty("platformName", "Android"));
        params.setUdid(System.getProperty("udid", "emulator-5554"));
        params.setDeviceName(System.getProperty("deviceName", "pixel_6"));


        switch (params.getPlatformName()) {
            case "Android":
                params.setSystemPort(System.getProperty("systemPort", "9999"));
                params.setChromeDriverPort(System.getProperty("chromeDriverPort", "9998"));
                break;
            case "iOS":
                params.setWebkitDebugProxyPort(System.getProperty("webkitDebugProxyPort", "10001"));
                params.setWdaLocalPort(System.getProperty("wdaLocalPort", "11001"));
                break;
        }
    }
}
