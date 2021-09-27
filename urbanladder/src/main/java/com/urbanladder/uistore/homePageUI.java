package com.urbanladder.uistore;

import org.openqa.selenium.By;

import com.urbanladder.reusablecomponents.ReusableComponents;

public class homePageUI extends ReusableComponents{
	
	public By searchBox = By.id("search");
	public By logo = By.xpath("//*[@class='logo-with-gradient']");
	public By emailID = By.name("email_id");
	public By subscribeBtn = By.xpath("//*[@name='commit']");
	public By successMsg = By.xpath("//div[contains(text(),\'Thanks for subscribing!\')]");
	public By storesBtn = By.xpath("//a[contains(@href,'furniture-stores?src=header')]");
//	String city="pune";
//	public By stores = By.className("//img[contains(@src,"+city+")]");
	public By contactUs = By.linkText("Contact Us");
	public By email = By.linkText("hello@urbanladder.com");
	public By wishlist = By.xpath("//a[@title='Wishlist']");
	public By signUpEmail = By.id("spree_user_email");
	public By signUpPwd = By.xpath("//input[@tabindex='2']");
	public By signupBtn = By.xpath("//input[@value='Sign Up']");
	public By signupErrorMsg = By.xpath("//li[@class='ulmessage error']");
	public By login = By.xpath("//a[contains(@class,'login-link link-color')]");
	public By loginEmail = By.xpath("//*[@placeholder='Email Address']");
	public By loginPwd = By.xpath("//*[@placeholder='Password']");
	public By loginSubmit = By.xpath("//*[@value='Log In']");
	public By firstSearchResult = By.xpath("//ul[@class='productlist small-block-grid-3']/li/div");
	public By addToCart = By.xpath("//button[contains(text(),'Add to Cart')]");
	public By firstProductId = By.xpath("//span[@itemprop='sku']");
	public By facebookPage = By.xpath("//div[@class='icofont-facebook']");
	public By playstore = By.xpath("//img[@class='android']");
	public By playstoreAppTitle = By.xpath("//h1[@class='AHFaub']/span");
	public By puneHadpsarStore = By.xpath("//img[contains(@src,'pune/hadapsar')]");
	public By visitUs = By.xpath("//a[contains(@href,'furniture-stores?src=g_footer')]");
	public By address = By.xpath("//address[@class='detail']/div");
	public By careers = By.xpath("//a[@href='/careers?src=g_footer']");
	
		
}
