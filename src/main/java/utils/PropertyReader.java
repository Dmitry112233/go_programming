package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private Properties property;
    private String propertyFilePath;

    public PropertyReader() {
        property = new Properties();
        propertyFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\setting.properties";
        try {
            property.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Can't find file with path: " + propertyFilePath);
        }
    }

    public String get(String value) {
        return property.getProperty(value);
    }

}
