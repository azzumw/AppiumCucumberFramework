package com.qa.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

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
    public void initialise(){}

    @After
    public void quit(){}
}
