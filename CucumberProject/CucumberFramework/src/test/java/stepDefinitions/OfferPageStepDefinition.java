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
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	//Single Responsibility Principle
	//Loosely coupled
	//Factory Design pattern
	public OfferPageStepDefinition(TestContextSetup testContextSetup) 
	{
		this.testContextSetup=testContextSetup;
	}
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException, IOException {
		switchToOffersPage();
		OffersPage offerPage = new OffersPage(testContextSetup.testBase.WebDriverManager());
		offerPage.searchItem(shortName);
	    Thread.sleep(2000);
	    offerPageProductName = offerPage.getProductName();
	}
	
	public void switchToOffersPage()
	{
		//if switched to offer page skip below part
		//if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.SwitchWindowToChild();
	}
	
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageproductName);
	   
	}
	
	
}
