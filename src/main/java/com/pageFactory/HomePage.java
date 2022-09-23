package com.pageFactory;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.generic.BaseTest;
import com.generic.WrapperFunctions;

public class HomePage {

	WrapperFunctions objWrapperFunctions=new WrapperFunctions();
	By loc_logoAmazonHomePage = By.xpath("//div[@id='nav-logo']//a[@id='nav-logo-sprites']");
	By loc_SeeMoreAmazonBasics = By.xpath("//h2[contains(.,'AmazonBasics')]/following::a[contains(.,'See more')][1]");
	By loc_inpSearchProduct=By.id("twotabsearchtextbox");
	By loc_chckBoxAmazonBasics=By.xpath("//span[text()='Amazon Basics']");
	By loc_icnSearchAllBox=By.xpath("//input[@id='nav-search-submit-button']");
	
	 //verify amazon home page
	public void verifyAmazonHomePageIsDisplayed() {
		BaseTest.driver.findElement(loc_logoAmazonHomePage).isDisplayed();
		Assert.assertTrue(BaseTest.driver.findElement(loc_logoAmazonHomePage).isDisplayed(),
				"Amazon home page is not displayed");
		System.out.println("Amazon Home page is displayed");
    }
	
	//verify amazon basics is displayed
	public void verifyAmazonBasicsIsDisplayed(){
		By loc_hdrAmazonBasics = By.xpath("//span[text()='" + "amazon basics" + "']");
		BaseTest.driver.findElement(loc_hdrAmazonBasics).isDisplayed();
		objWrapperFunctions.scrollToViewElement(loc_hdrAmazonBasics);
		Assert.assertTrue(BaseTest.driver.findElement(loc_hdrAmazonBasics).isDisplayed(),
				"Amazon Basic is not displayed");
		System.out.println("Amazon Basic is displayed");
	}
	
	
	//Click on Amazon Basics Brand
	public void clickOnAmazonBasicsCheckBox(){
		objWrapperFunctions.scrollToViewElement(loc_chckBoxAmazonBasics);
		Assert.assertTrue(BaseTest.driver.findElement(loc_chckBoxAmazonBasics).isDisplayed(),
				"Amazon Basic check box is displayed");
		BaseTest.driver.findElement(loc_chckBoxAmazonBasics).click();
		System.out.println("check the amazon basics check box in left side filter section");
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
		
		public void searchAllProduct(String strProduct){
			BaseTest.driver.findElement(loc_inpSearchProduct).isDisplayed();
			Assert.assertTrue(BaseTest.driver.findElement(loc_inpSearchProduct).isDisplayed(),
					"Search All product input box is displayed");
			BaseTest.driver.findElement(loc_inpSearchProduct).sendKeys(strProduct);
		}
		
		public void clickOnSearchAllProduct(){
			BaseTest.driver.findElement(loc_icnSearchAllBox).click();
			}
		
		
}
