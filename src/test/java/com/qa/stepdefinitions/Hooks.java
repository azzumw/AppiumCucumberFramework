package com.qa.stepdefinitions;

import com.qa.pages.BasePage;
import com.qa.utils.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.OutputType;

import java.io.IOException;

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
    public void initialise() throws IOException {
        testUtils.log().info("Hooks: Before");
        new BasePage().activateApp();
        new VideoManager().startRecording();
    }

    //executes after every scenario
    @After
    public void quit(Scenario scenario) throws IOException {
        testUtils.log().info("Hooks: After");


        if(scenario.isFailed()){
            byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
        }

        new VideoManager().stopRecording(scenario);
        new BasePage().terminateApp();
    }
}
