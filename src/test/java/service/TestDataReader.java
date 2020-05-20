package service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBoundle= ResourceBundle.getBundle(System.getProperty("environment"));
    public static String getTestData(String key){
        return resourceBoundle.getString(key);
    }
}
