package com.spotify.developer.oauth2.utils;

import java.util.Properties;

public class ConfigLoader {
    private static ConfigLoader configLoader;
   private Properties properties;


    private ConfigLoader() {
      //  properties = PropertyUtils.propertyLoader("src/main/resources/data.properties");
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getUserID() {
        return properties.getProperty("user_id");
    }

}
