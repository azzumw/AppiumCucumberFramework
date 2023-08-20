package com.qa.stepdefinitions;

import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.Test;

/**
 * hooks to start the appium server
 * to initialise the appium driver
 *
 * to stop appium server
 * to quit the driver
 *
 * Executed after every cucumber scenario
 * */
public class Hooks {

    @Before
    public void initialise(){
        GlobalParams globalParams = new GlobalParams();
        globalParams.initializeGlobalParams();

        ThreadContext.put(TestUtils.ROUTING_KEY,globalParams.getPlatformName() + TestUtils.UNDERSCORE + globalParams.getDeviceName());
    }

    @After
    public void quit(){}
}
