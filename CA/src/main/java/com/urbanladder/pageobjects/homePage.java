package com.urbanladder.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.urbanladder.uistore.homePageUI;

public class homePage extends homePageUI {
	public homePage(WebDriver driver) {
		homePage.driver=driver;
	}
	
	public WebElement searchBox() {
	 return driver.findElement(searchBox);
	}
	public WebElement logo() {
		 return driver.findElement(logo);
	}
	public WebElement emailID() {
		 return driver.findElement(emailID);
	}
	public WebElement subscribeBtn() {
		 return driver.findElement(subscribeBtn);
	}
	public WebElement successMsg() {
		 return driver.findElement(successMsg);
	}
	public WebElement storesBtn() {
		 return driver.findElement(storesBtn);
	}

	public WebElement signUpEmail() {
		 return driver.findElement(signUpEmail);
	}
	public WebElement signUpPwd() {
		 return driver.findElement(signUpPwd);
	}
	public WebElement signupBtn() {
		 return driver.findElement(signupBtn);
	}
	public WebElement contactUs() {
		 return driver.findElement(contactUs);
	}
	public WebElement email() {
		 return driver.findElement(email);
	}
	public WebElement wishlist() {
		 return driver.findElement(wishlist);
	}
	public WebElement signupErrorMsg() {
		 return driver.findElement(signupErrorMsg);
	}
	public WebElement login() {
		 return driver.findElement(login);
	}
	public WebElement loginPwd() {
		 return driver.findElement(loginPwd);
	}
	public WebElement loginSubmit() {
		 return driver.findElement(loginSubmit);
	}
	public WebElement loginEmail() {
		 return driver.findElement(loginEmail);
	}
	public WebElement firstSearchResult() {
		 return driver.findElement(firstSearchResult);
	}
	public WebElement addToCart() {
		 return driver.findElement(addToCart);
	}
	public WebElement firstProductId() {
		 return driver.findElement(firstProductId);
	}
	public WebElement facebookPage() {
		 return driver.findElement(facebookPage);
	}
	public WebElement playstore() {
		 return driver.findElement(playstore);
	}
	public WebElement playstoreAppTitle() {
		 return driver.findElement(playstoreAppTitle);
	}
	public WebElement puneHadpsarStore() {
		 return driver.findElement(puneHadpsarStore);
	}
	public WebElement visitUs() {
		 return driver.findElement(visitUs);
	}
	public WebElement address() {
		 return driver.findElement(address);
	}
	public WebElement careers() {
		 return driver.findElement(careers);
	}
}
