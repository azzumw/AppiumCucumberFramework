package com.qa.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private static Properties properties = new Properties();
    private static InputStream inputStream;
    public  Properties getProperties() throws IOException {
//        InputStream inputStream = null;
        String propertiesFilename = "/config.properties";

        if (properties.isEmpty()){
            TestUtils.log().info("loading config properties");
            try{
                inputStream = PropertyManager.class.getResourceAsStream(propertiesFilename);
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
                TestUtils.log().fatal("unable to load config.properties. aborting"+e.getMessage());
            }finally {
                if(inputStream!=null){
                    inputStream.close();
                }
            }
        }
        return properties;
    }
}
