//package com.qa.runners;
//
//import com.qa.utils.DriverManager;
//import com.qa.utils.GlobalParams;
//import com.qa.utils.ServerManager;
//import com.qa.utils.TestUtils;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.apache.logging.log4j.ThreadContext;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//
//import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        plugin = {"pretty", "html:target/cucumber/cucumber.html","summary"},
//        features = {"src/test/resources"},
//        glue = {"com.qa.stepdefinitions"},
//        snippets = CAMELCASE,
////        dryRun = true,
//        tags = "@test",
//        monochrome = true)
//public class MyRunnerTest {
//
//    @BeforeClass
//    public static void initialise() throws Exception{
//        GlobalParams globalParams = new GlobalParams();
//        globalParams.initializeGlobalParams();
//
//        //log4j2 create folders for each device
//        ThreadContext.put("ROUTINGKEY", globalParams.getPlatformName() + TestUtils.UNDERSCORE + globalParams.getDeviceName());
//
//        new ServerManager().startServer();
//        new DriverManager().initDriver();
//    }
//
//    @AfterClass
//    public static void afterClass() throws Exception {
//        ServerManager serverManager = new ServerManager();
//        DriverManager driverManager = new DriverManager();
//
//        if (driverManager.getDriver() != null) {
//            driverManager.getDriver().quit();
//            driverManager.setDriver(null);
//        }
//
//        if (serverManager.getServer() != null) {
//            serverManager.getServer().stop();
//        }
//    }
//}
//
////append Test keyword to the classname
