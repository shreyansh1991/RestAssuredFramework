package com.spotify.developer.oauth2.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils {
    private static Properties property = new Properties();

    /**
     * Private constructor to avoid external instantiation
     */
    private PropertyUtils() {
    }

    static {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data.properties"))) {
            property.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return property.getProperty(key);
    }
}
