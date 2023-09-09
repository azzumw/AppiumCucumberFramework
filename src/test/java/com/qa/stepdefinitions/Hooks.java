package com.qa.stepdefinitions;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import com.qa.utils.TestUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.ThreadContext;

/**
 * hooks to start the appium server
 * to initialise the appium driver
 * <p>
 * to stop appium server
 * to quit the driver
 * <p>
 * Executed before and after every cucumber scenario
 */
public class Hooks {
    private TestUtils testUtils = new TestUtils();

    //executes before every scenario
    @Before
    public void initialise() {
        testUtils.log().info("Hooks: Before");

        GlobalParams globalParams = new GlobalParams();
        globalParams.initializeGlobalParams();

        //log4j2 create folders for each device
        ThreadContext.put("ROUTINGKEY", globalParams.getPlatformName() + TestUtils.UNDERSCORE + globalParams.getDeviceName());

        new ServerManager().startServer();
        new DriverManager().initDriver();

    }

    //executes after every scenario
    @After
    public void quit() {
        testUtils.log().info("Hooks: After");
        ServerManager serverManager = new ServerManager();
        DriverManager driverManager = new DriverManager();
        if (driverManager.getDriver() != null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }

        if (serverManager.getServer() != null) {
            serverManager.getServer().stop();
        }
    }
}
