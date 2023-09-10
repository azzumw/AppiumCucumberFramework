package com.qa.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private TestUtils testUtils = new TestUtils();
    private static Properties properties = new Properties();
    private static InputStream inputStream;
    public  Properties getProperties() throws IOException {
//        InputStream inputStream = null;
        String propertiesFilename = "/config.properties";

        if (properties.isEmpty()){
            testUtils.log().info("loading config properties");
            try{
                inputStream = this.getClass().getResourceAsStream(propertiesFilename);
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
                testUtils.log().fatal("unable to load config.properties. aborting"+e.getMessage());
            }finally {
                if(inputStream!=null){
                    inputStream.close();
                }
            }
        }
        return properties;
    }
}
