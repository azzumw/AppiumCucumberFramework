package com.qa.runners;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import com.qa.utils.TestUtils;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.*;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber/Pixel_3/cucumber.html","summary"},
        features = {"src/test/resources"},
        glue = {"com.qa.stepdefinitions"},
        tags = "@test",
        monochrome = true)
public class TestngPixel3RunnerTest {
    private TestNGCucumberRunner testNGCucumberRunner;

    @Parameters({"platformName", "udid", "deviceName", "systemPort", "chromeDriverPort", "wdaLocalPort", "webkitDebugProxyPort"})
    @BeforeClass(alwaysRun = true)
    public void beforeClass(String platformName, String udid, String deviceName,
                            @Optional("Android") String systemPort,
                            @Optional("Android") String chromeDriverPort,
                            @Optional("iOS") String wdaLocalPort,
                            @Optional("iOS") String webkitDebugProxyPort) {


        //log4j2 create folders for each device
        ThreadContext.put("ROUTINGKEY",platformName + TestUtils.UNDERSCORE + deviceName);

        GlobalParams params = new GlobalParams();
        //note:cannot use initialiseParam method og GlobalParams class for TestNG. only for Junit.
        params.setPlatformName(platformName);
        params.setUdid(udid);
        params.setDeviceName(deviceName);

        switch (params.getPlatformName()) {
            case "Android":
                params.setChromeDriverPort(chromeDriverPort);
                params.setSystemPort(systemPort);
                break;
            case "iOS":
                params.setWdaLocalPort(wdaLocalPort);
                params.setWebkitDebugProxyPort(webkitDebugProxyPort);
                break;
        }


        new ServerManager().startServer();
        new DriverManager().initDriver();

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

    }

    @Test(groups = "cucumber", description = "Runs cucumber scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios(){
        return testNGCucumberRunner.provideScenarios();
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {

        ServerManager serverManager = new ServerManager();
        DriverManager driverManager = new DriverManager();

        if (driverManager.getDriver() != null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }

        if (serverManager.getServer() != null) {
            serverManager.getServer().stop();
        }

        if(testNGCucumberRunner != null){
            testNGCucumberRunner.finish();
        }
    }
}
