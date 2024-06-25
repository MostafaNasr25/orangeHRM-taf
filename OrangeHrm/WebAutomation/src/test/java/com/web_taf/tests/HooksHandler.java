package com.web_taf.tests;

import com.web_taf.properties_reading.ReadPropertiesFile;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.IOException;

public class HooksHandler extends BaseTest {

  @Before(order = 1)
  public void setUp() throws IOException {

      EdgeOptions options = new EdgeOptions();
      options.addArguments("start-maximized");
      options.addArguments("--disable-extensions");
      edgeDriver = new EdgeDriver(options);
      properties = ReadPropertiesFile.setProperties();

  }

  @After
  public void tearDown(){
      edgeDriver.quit();
  }

}
