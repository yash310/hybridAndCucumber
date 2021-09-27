package com.urbanladder.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyFileReader {
	public Properties prop;
	public String getProperty(String key) throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\config.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
}
