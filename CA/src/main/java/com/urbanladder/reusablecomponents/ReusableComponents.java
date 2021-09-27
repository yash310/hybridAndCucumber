package com.urbanladder.reusablecomponents;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.urbanladder.utility.propertyFileReader;

public class ReusableComponents {
	
	public static WebDriver driver;
	
	public static WebDriver initializeDriver() throws IOException {
		propertyFileReader pfr=new propertyFileReader();
		String browsername = pfr.getProperty("browser");
//		System.out.println(browsername);
		
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		if(browsername.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.msedgedriver.driver", ".\\drivers\\chromedriver.exe");
			 driver = new EdgeDriver();
		}
		return driver;
	}
	

}
