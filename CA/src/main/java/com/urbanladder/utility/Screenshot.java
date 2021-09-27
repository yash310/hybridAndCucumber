package com.urbanladder.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.urbanladder.reusablecomponents.ReusableComponents;


public class Screenshot extends ReusableComponents {
	
	public static void fun() throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\errorscreenshots\\capture.png"));
	}
}
