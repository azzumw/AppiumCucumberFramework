package com.qa.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


import java.io.File;

public class ServerManager {

    private TestUtils testUtils = new TestUtils();

    private static String driverExe = "/opt/homebrew/bin/node";

    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();

    public static AppiumDriverLocalService getAppiumServiceDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }


    public AppiumDriverLocalService getCustomAppiumService() {
        testUtils.log().info("Global Parameters inside Server Manager");
        GlobalParams params = new GlobalParams();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File(driverExe))
                .usingAnyFreePort().withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withLogFile(new File(params.getPlatformName() + TestUtils.UNDERSCORE + params.getDeviceName() + File.separator + "Server.log")));
    }

    public  AppiumDriverLocalService getServer() {
        return server.get();
    }

    public void startServer() {
        testUtils.log().info("starting appium server");

        AppiumDriverLocalService localServer = getCustomAppiumService();
        localServer.start();

        if (localServer == null || !localServer.isRunning()) {
            testUtils.log().fatal("unable to start server. aborting.");
            throw new AppiumServerHasNotBeenStartedLocallyException("appium server not started. Aborting.");
        }


        localServer.clearOutPutStreams();
        server.set(localServer);
//        server = getAppiumServiceDefault();
//        server.start();

        testUtils.log().info("appium server started");
    }

    public  void stopServer() {
        testUtils.log().info("Stopping appium server");
        server.get().stop();
        testUtils.log().info("Appium Server Stopped");
    }
}
