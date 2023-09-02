package com.qa.stepdefinitions;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import com.qa.utils.TestUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.apache.logging.log4j.ThreadContext;

/**
 * hooks to start the appium server
 * to initialise the appium driver
 *
 * to stop appium server
 * to quit the driver
 *
 * Executed before and after every cucumber scenario
 * */
public class Hooks {

    @BeforeAll
    public void before_all(){
        TestUtils.log().info("Hooks: Before all");
        GlobalParams globalParams = new GlobalParams();
        globalParams.initializeGlobalParams();

        ThreadContext.put(TestUtils.ROUTING_KEY,globalParams.getPlatformName() + TestUtils.UNDERSCORE + globalParams.getDeviceName());

        new ServerManager().startServer();
        new DriverManager().initDriver();
    }

    @Before
    public void initialise(){
        TestUtils.log().info("Hooks: Before");

    }

    @After
    public void quit(){
        TestUtils.log().info("Hooks: After");
    }

    public void after_all(){
        TestUtils.log().info("Hooks: After all");
        ServerManager serverManager = new ServerManager();
        DriverManager driverManager= new DriverManager();
        if(driverManager.getDriver() != null){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }

        if(serverManager.getServer()!= null){
            serverManager.getServer().stop();
        }
    }
}
