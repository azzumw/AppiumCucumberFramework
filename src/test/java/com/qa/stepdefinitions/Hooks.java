package com.qa.stepdefinitions;

import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import com.qa.utils.TestUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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

    @Before
    public void initialise(){
        GlobalParams globalParams = new GlobalParams();
        globalParams.initializeGlobalParams();

        ThreadContext.put(TestUtils.ROUTING_KEY,globalParams.getPlatformName() + TestUtils.UNDERSCORE + globalParams.getDeviceName());

        new ServerManager().startServer();
    }

    @After
    public void quit(){
        ServerManager serverManager = new ServerManager();
        if(serverManager.getServer()!= null){
            serverManager.getServer().stop();
        }
    }
}
