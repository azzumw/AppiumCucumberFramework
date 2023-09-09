package com.qa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber/cucumber.html","summary"},
        features = {"src/test/resources"},
        glue = {"com.qa.stepdefinitions"},
        snippets = CAMELCASE,
//        dryRun = true,
        monochrome = true)
public class MyRunnerTest {
}

//append Test keyword to the classname
