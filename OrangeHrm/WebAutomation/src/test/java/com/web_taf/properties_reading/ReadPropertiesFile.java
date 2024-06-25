package com.web_taf.properties_reading;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

    private static final String ConfigPath = "resources/config.properties";

    public static Properties setProperties() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(ConfigPath);
        configProperties.load(inputStream);
        return configProperties;
    }

}
