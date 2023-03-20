package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
	public	 WebDriver driver;
	public String landingPageproductName;
	public String offerPageProductName;
	public String checkoutPageproductName;
	public CheckoutPage checkoutPage;
	TestContextSetup testContextSetup;
	
	
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) 
	{
		this.testContextSetup=testContextSetup;
		this.checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	
	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo()
	{
		
		Assert.assertTrue(checkoutPage.VerifyPromoBtn());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
	}
	
	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout(String name)
	{
		checkoutPage.CheckoutItems();
		//Thread.sleep(2000);
		testContextSetup.checkoutPageproductName=checkoutPage.getProductName().split("-")[0].trim();
		Assert.assertTrue(testContextSetup.checkoutPageproductName.contains(name));
	}
		
	
	
	
	
	
}
