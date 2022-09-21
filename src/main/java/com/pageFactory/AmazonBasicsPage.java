package com.pageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.generic.BaseTest;
import com.generic.WrapperFunctions;

public class AmazonBasicsPage {

	WrapperFunctions objWrapperFunctions=new WrapperFunctions();
	
	By loc_hdrAmazonBasics = By.xpath("//h1//span[contains(.,'amazonbasics')]");
	By loc_hdrFromOurBrands = By.xpath("//div[@class='a-section']//div[@class='a-section a-spacing-small']//span[contains(.,'From Our Brands')]");
	By loc_checkboxOurBrands = By.xpath("//span[contains(.,'Our Brands')]/preceding::span[contains(.,'From Our Brands')]/following::input[@type='checkbox'][1]");
	By loc_btnNextPage = By.xpath("//a[contains(.,'Next')]");
	By loc_listProducts= By.xpath("//div[@class='a-section a-spacing-medium']//h2//span");
	By loc_imgProduct= By.xpath("//img[@alt='Amazon Basics 8-Sheet Capacity, Cross-Cut Paper and Credit Card Shredder, 4.1 Gallon']");
	
	
	//span[contains(.,'Amazon Basics 48 Pack AA High-Performance Alkaline Batteries, 10-Year Shelf Life, Easy to Open Value Pack')]
        
	//verify amazon basics page
		public void verifyAmazonBasicsPageIsDisplayed() {
			BaseTest.driver.findElement(loc_hdrAmazonBasics).isDisplayed();
			Assert.assertTrue(BaseTest.driver.findElement(loc_hdrAmazonBasics).isDisplayed(),
					"Amazon basics page is not displayed");
			System.out.println("Amazon basics page is displayed");
	    }
		
		 //verify from our brands header is displayed
		public void verifyFromOurBrandsHeaderIsDisplayed() {
			BaseTest.driver.findElement(loc_hdrFromOurBrands).isDisplayed();
			objWrapperFunctions.scrollToViewElement(loc_hdrFromOurBrands);
			Assert.assertTrue(BaseTest.driver.findElement(loc_hdrFromOurBrands).isDisplayed(),
					"From our brands checkbox is not displayed");
			System.out.println("'From our brands' header is displayed");
	    }
		
		 //click on our brand checkbox
		public void clickOnOurBrandCheckbox() {
			BaseTest.driver.findElement(loc_checkboxOurBrands).isDisplayed();
			Assert.assertTrue(BaseTest.driver.findElement(loc_checkboxOurBrands).isDisplayed(),
					"Our brands checkbox is not selected");
			objWrapperFunctions.clickOnWebElementUsingActions(loc_checkboxOurBrands);
			System.out.println("'Our brands' from 'From our brands' checkbox is selected");
	    }
		
		//verify our brands checkbox is selected
		public void verifyOurBrandsCheckboxIsSelected(){
			objWrapperFunctions.setWaitForElementToBeVisible(60, loc_checkboxOurBrands);
			objWrapperFunctions.scrollToViewElement(loc_checkboxOurBrands);
			Assert.assertTrue(BaseTest.driver.findElement(loc_checkboxOurBrands).isSelected(),
					"Our brands checkbox is not selected");
			System.out.println("Verify 'Our brands' from 'From our brands' checkbox is selected");
		}
		
		public void getListOfProducts(){
			System.out.println("Enter into getproductlist");
			
		 List<WebElement> products = BaseTest.driver.findElements(loc_listProducts);
		 for(WebElement product : products){
		 System.out.println(product.getText());
		 
		 if(product.getText().equals("Amazon Basics 8-Sheet Capacity, Cross-Cut Paper and Credit Card Shredder, 4.1 Gallon")){
			 BaseTest.driver.findElement(loc_imgProduct).isDisplayed();
			 objWrapperFunctions.scrollToViewElement(loc_imgProduct);
			 objWrapperFunctions.setWaitForElementToBeClickable(60, loc_imgProduct);
			 break;
		 }
		 else{
			 System.out.println("no");
			}
		}
		 clickOnNextPage();
}

		
     public void clickOnNextPage(){
    	 
	 BaseTest.driver.findElement(loc_btnNextPage).isDisplayed();
	 objWrapperFunctions.scrollToViewElement(loc_btnNextPage);
	 BaseTest.driver.findElement(loc_btnNextPage).click();
	 System.out.println("Click on next page: Next page gets loaded");
	 BaseTest.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	 getListOfProducts();
	
}}
