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
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	public	 WebDriver driver;
	public String landingPageproductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	public LandingPageStepDefinition(TestContextSetup testContextSetup) 
	{
		this.testContextSetup=testContextSetup;
		this.landingPage=testContextSetup.pageObjectManager.getLandingPage();
	}
	
	
	@Given("User is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() throws IOException {
	 
		//testContextSetup.testBase.WebDriverManager();
		 Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}
	
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		
		landingPage.searchItem(shortName);
		Thread.sleep(2000);	
		testContextSetup.landingPageproductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageproductName +" is extracted from Home page");
		
	}
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity)
	{
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
	
	
	
	
	
}
