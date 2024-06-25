package com.web_taf.tests;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/java/com/web_taf/tests/newUserAtAdminTab.feature",
        glue = {"com.web_taf.tests"},
        publish = true,
        monochrome = true

)

public class Runner extends AbstractTestNGCucumberTests {

}
