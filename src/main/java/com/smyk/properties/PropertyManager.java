package com.smyk.properties;

import com.smyk.utils.LogUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;


public class PropertyManager {

    private static final Logger logger = LogManager.getLogger(PropertyManager.class.getSimpleName());
    private static final Properties testData = new Properties();
    private static final Properties systemProperties = new Properties();
    private static final String testDataFilesFolder = "testdata/";
    private static final String systemPropertiesFolder = "systemConfig/";
    private static final String systemPropertiesFilename = "setup.properties";

    public PropertyManager(String testDataFileName){
        loadSystemProperties(systemPropertiesFilename);
        loadProperties(testDataFilesFolder + testDataFileName, testData);
    }

    public String getProperty(String propertyName){
        return testData.getProperty(propertyName);
    }

    private void loadProperties(String filePath, Properties properties){
        logger.info("Trying to access property file: " + filePath);
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            properties.load(inputStream);
        } catch (Exception e) {
            logger.error("Property file with path: " + filePath + " cannot be opened");
            LogUtil.logStackTrace(e, logger);
        }
    }

    private void loadSystemProperties(String filename){
        logger.info("Loading system properties from file");
        systemProperties.putAll(System.getProperties());
        loadProperties(systemPropertiesFolder + filename, systemProperties);
        logger.info("Setting up system properties");
        System.setProperties(systemProperties);
    }
}
