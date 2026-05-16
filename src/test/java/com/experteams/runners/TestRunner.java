package com.experteams.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/resources/features",

        glue = "com.experttunisie.stepdefinitions",

        
        //tags = "@Footer",

        
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        },

        monochrome = true,

        publish = false
)

public class TestRunner
        extends AbstractTestNGCucumberTests {

}