package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.urbanladder.pageobjects.homePage;
import com.urbanladder.reusablecomponents.ReusableComponents;
import com.urbanladder.utility.propertyFileReader;

@RunWith(Cucumber.class)
public class MyStepDefinitions extends ReusableComponents{
	String productId;
	propertyFileReader pfr=new propertyFileReader();
	homePage hp=new homePage(driver);

    @Given("^The driver is initialized$")
    public void the_driver_is_initialized() throws Throwable {
    	driver=initializeDriver();
		driver.manage().window().maximize();
    }

    @When("^user is on urban ladder signup page$")
    public void user_is_on_urban_ladder_signup_page() throws Throwable {
    	hp.wishlist().click();
    }

    @When("^user is on urban ladder login page$")
    public void user_is_on_urban_ladder_login_page() throws Throwable {
    	hp.wishlist().click();
		hp.login().click();
    }

    @When("^user is on urban ladder home page$")
    public void user_is_on_urban_ladder_home_page() throws Throwable {
    	driver.get(pfr.getProperty("url"));
    }

    @Then("^verify if the title contains Urban Ladder$")
    public void verify_if_the_title_contains_urban_ladder() throws Throwable {
    	Assert.assertTrue(driver.getTitle().contains("Urban Ladder"));
    }

    @Then("^verify if the subscription is successful$")
    public void verify_if_the_subscription_is_successful() throws Throwable {
    	Assert.assertEquals(hp.successMsg().getText(),pfr.getProperty("successMessage"));
    }

    @Then("^verify if the support email is displayed$")
    public void verify_if_the_support_email_is_displayed() throws Throwable {
    	Assert.assertEquals(hp.email().getText(),pfr.getProperty("supportEmail"));
    }

    @Then("^verify if sign up is successful$")
    public void verify_if_sign_up_is_successful() throws Throwable {
    	Assert.assertEquals(hp.signupErrorMsg().getText(), pfr.getProperty("signUpErrorMessage"));
    }

    @Then("^verify if login is successful$")
    public void verify_if_login_is_successful() throws Throwable {
        throw new PendingException();
    }

    @Then("^verify if the product is added to cart$")
    public void verify_if_the_product_is_added_to_cart() throws Throwable {
    	
		ArrayList<WebElement> products = new ArrayList<WebElement>((Collection<? extends WebElement>) driver.findElements(By.xpath("//a[contains(@href,'"+productId+"')]")));
	    if(products.size()!=0) {
//	    	System.out.println(productId);
	    }
    }

    @Then("^verify if it is redirected to the correct URL$")
    public void verify_if_it_is_redirected_to_the_correct_url() throws Throwable {
    	Assert.assertEquals(driver.getCurrentUrl(), pfr.getProperty("facebookURL"));
    }

    @Then("^verify if correct App is displayed$")
    public void verify_if_correct_app_is_displayed() throws Throwable {
    	String appName = hp.playstoreAppTitle().getAttribute("innerHTML");
	    Assert.assertEquals(appName, pfr.getProperty("playstoreAppTitle"));
    }

    @Then("^verify if the correct store address is displayed$")
    public void verify_if_the_correct_store_address_is_displayed() throws Throwable {
    	String expAddress = hp.address().getAttribute("innerHTML");	    
		Assert.assertEquals(pfr.getProperty("puneAddress"), expAddress);
    }

    @Then("^verify that the user ias navigated to the right URL$")
    public void verify_that_the_user_ias_navigated_to_the_right_url() throws Throwable {
    	Assert.assertEquals(driver.getCurrentUrl(), pfr.getProperty("careersURL"));
    }

    @And("^user enters \"([^\"]*)\" and clicks on subscribe$")
    public void user_enters_something_and_clicks_on_subscribe(String strArg1) throws Throwable {
    	hp.emailID().sendKeys(strArg1);
		hp.emailID().sendKeys(Keys.ENTER);
		synchronized(driver)
		{
		    driver.wait(1000);
		}	
    }

    @And("^user clicks on contact us button in footer$")
    public void user_clicks_on_contact_us_button_in_footer() throws Throwable {
    	hp.contactUs().click();
    }

    

    @And("^clicks on Signup$")
    public void clicks_on_signup() throws Throwable {
    	hp.signupBtn().click();
    }

    @And("^clicks on Login$")
    public void clicks_on_login() throws Throwable {
    	hp.loginSubmit().click();
    }

    @And("^user selects a product$")
    public void user_selects_a_product() throws Throwable {
    	hp.searchBox().sendKeys("work table");
		hp.searchBox().sendKeys(Keys.ENTER);
//		String currentWindowHandle=driver.getWindowHandle();
		hp.firstSearchResult().click();
		ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(windowHandles.get(1));
	    productId = hp.firstProductId().getAttribute("innerHTML");
    }

    @And("^clicks on Add to cart$")
    public void clicks_on_add_to_cart() throws Throwable {
    	hp.addToCart().click();
    }

    @And("^user clicks on facebook icon$")
    public void user_clicks_on_facebook_icon() throws Throwable {
        throw new PendingException();
    }

    @And("^user clicks on Playstore icon $")
    public void user_clicks_on_playstore_icon() throws Throwable {
    	hp.facebookPage().click();
    }

    @And("^user clicks on visit us $")
    public void user_clicks_on_visit_us() throws Throwable {
    	hp.visitUs().click();
		
    }

    @And("^clicks on the store $")
    public void clicks_on_the_store() throws Throwable {
    	hp.puneHadpsarStore().click();
    }

    @And("^user clicks Careers in footer tab $")
    public void user_clicks_careers_in_footer_tab() throws Throwable {
    	hp.careers().click();
    }
    
    @And("^user enters \"([^\"]*)\" and \"([^\"]*)\" on signup page$")
    public void user_enters_something_and_something_on_signup_page(String strArg1, String strArg2) throws Throwable {
    	hp.signUpEmail().sendKeys(strArg1);
		hp.signUpPwd().sendKeys(strArg2);
    }
    
    @And("^user enters \"([^\"]*)\" and \"([^\"]*)\" on login page$")
    public void user_enters_something_and_something_on_login_page(String strArg1, String strArg2) throws Throwable {
    	hp.loginEmail().sendKeys(strArg1);
		hp.loginPwd().sendKeys(strArg2);
    }

}