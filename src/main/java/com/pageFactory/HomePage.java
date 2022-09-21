package com.pageFactory;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.generic.BaseTest;
import com.generic.WrapperFunctions;

public class HomePage {

	WrapperFunctions objWrapperFunctions=new WrapperFunctions();
	By loc_logoAmazonHomePage = By.xpath("//div[@id='nav-logo']//a[@id='nav-logo-sprites']");
	By loc_hdrAmazonBasics = By.xpath("//h2[contains(.,'AmazonBasics')]");
	By loc_SeeMoreAmazonBasics = By.xpath("//h2[contains(.,'AmazonBasics')]/following::a[contains(.,'See more')][1]");
	
	 //verify amazon home page
	public void verifyAmazonHomePageIsDisplayed() {
		BaseTest.driver.findElement(loc_logoAmazonHomePage).isDisplayed();
		Assert.assertTrue(BaseTest.driver.findElement(loc_logoAmazonHomePage).isDisplayed(),
				"Amazon home page is not displayed");
		System.out.println("Amazon Home page is displayed");
    }
	
	//verify amazon basics is displayed
	public void verifyAmazonBasicsIsDisplayed(){
		BaseTest.driver.findElement(loc_hdrAmazonBasics).isDisplayed();
		objWrapperFunctions.scrollToViewElement(loc_hdrAmazonBasics);
		Assert.assertTrue(BaseTest.driver.findElement(loc_hdrAmazonBasics).isDisplayed(),
				"Amazon Basic is not displayed");
		System.out.println("Amazon Basic is displayed");
	}
	
	//click on see more of amazon basics 
		public void clickOnSeeMoreOfAmazonBasics(){
			BaseTest.driver.findElement(loc_SeeMoreAmazonBasics).isDisplayed();
			objWrapperFunctions.scrollToViewElement(loc_SeeMoreAmazonBasics);
			Assert.assertTrue(BaseTest.driver.findElement(loc_SeeMoreAmazonBasics).isDisplayed(),
					"Amazon Basic is not displayed");
			BaseTest.driver.findElement(loc_SeeMoreAmazonBasics).click();
			System.out.println("Clicked on see more amazon basics");
		}
}
