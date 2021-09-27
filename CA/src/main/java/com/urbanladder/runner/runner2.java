package com.urbanladder.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.urbanladder.pageobjects.homePage;
import com.urbanladder.reusablecomponents.ReusableComponents;
import com.urbanladder.utility.propertyFileReader;

public class runner2 extends ReusableComponents{
//	private static Logger log = LogManager.getLogger(runner.class.getName());
	propertyFileReader pfr=new propertyFileReader();
	homePage hp=new homePage(driver);
	
	@BeforeMethod
	public void launchDriver() throws IOException {
		driver=initializeDriver();
		driver.manage().window().maximize();
		driver.get(pfr.getProperty("url"));
		
	}
	@Test
	public void validateTitle() throws IOException{
		driver.get(pfr.getProperty("url"));
		Assert.assertTrue(driver.getTitle().contains("Urban Ladder"));
	}
	@Test(priority=1)
	public void emailSubscriptionValidation() throws IOException, InterruptedException {
		hp.emailID().sendKeys(pfr.getProperty("email"));
		hp.emailID().sendKeys(Keys.ENTER);
		synchronized(driver)
		{
		    driver.wait(1000);
		}	
		Assert.assertEquals(hp.successMsg().getText(),pfr.getProperty("successMessage"));
			
	}
	
	@Test
	public void contactUsValidation() throws IOException {
		hp.contactUs().click();
		Assert.assertEquals(hp.email().getText(),pfr.getProperty("supportEmail"));
	}
	
	@Test
	public void signup() throws IOException, InterruptedException {
		hp.wishlist().click();
		hp.signUpEmail().sendKeys(pfr.getProperty("email"));
		hp.signUpPwd().sendKeys(pfr.getProperty("password"));
		hp.signupBtn().click();
		Assert.assertEquals(hp.signupErrorMsg().getText(), pfr.getProperty("signUpErrorMessage"));
	}
	
	@Test
	public void login() throws IOException, InterruptedException {
		hp.wishlist().click();
		hp.login().click();
		hp.loginEmail().sendKeys(pfr.getProperty("email"));
		hp.loginPwd().sendKeys(pfr.getProperty("password"));
		hp.loginSubmit().click();
		
	}
	
	@Test
	public void addingToCart() throws IOException, InterruptedException {
		hp.searchBox().sendKeys("work table");
		hp.searchBox().sendKeys(Keys.ENTER);
//		String currentWindowHandle=driver.getWindowHandle();
		hp.firstSearchResult().click();
		ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(windowHandles.get(1));
	    String productId = hp.firstProductId().getAttribute("innerHTML");
	    hp.addToCart().click();
	    ArrayList<WebElement> products = new ArrayList<WebElement>((Collection<? extends WebElement>) driver.findElements(By.xpath("//a[contains(@href,'"+productId+"')]")));
	    if(products.size()!=0) {
//	    	System.out.println(productId);
	    }
	}
	@Test
	public void validatingFacebookURL() throws IOException, InterruptedException {
//		String currentWindowHandle=driver.getWindowHandle();
		hp.facebookPage().click();
		ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(windowHandles.get(1));
	    Assert.assertEquals(driver.getCurrentUrl(), pfr.getProperty("facebookURL"));
	    }
	
	@Test
	public void playstore() throws IOException, InterruptedException {
		hp.playstore().click();
		ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(windowHandles.get(1));
	    String appName = hp.playstoreAppTitle().getAttribute("innerHTML");
	    Assert.assertEquals(appName, pfr.getProperty("playstoreAppTitle"));
	    }
	
	@Test
	public void addressValidation() throws IOException, InterruptedException {
		hp.visitUs().click();
		hp.puneHadpsarStore().click();
		String expAddress = hp.address().getAttribute("innerHTML");	    
		Assert.assertEquals(pfr.getProperty("puneAddress"), expAddress);
		}
	@Test
	public void validateCareersURL() throws IOException, InterruptedException {
		hp.careers().click();
		Assert.assertEquals(driver.getCurrentUrl(), pfr.getProperty("careersURL"));
		}
	
	@AfterMethod
	public void closeDriver(){
		driver.quit();
}
	
}


