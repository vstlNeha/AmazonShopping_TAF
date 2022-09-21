package com.pageFactory;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.generic.BaseTest;

public class ProductPage {

	By loc_btnSize = By.xpath("//div[@id='variation_size_name']//span[@class='selection'][contains(.,'8 Sheet')]");
	By loc_btnAddToCart = By.xpath("//span[@class='a-button-inner']//input[@id='add-to-cart-button']");
	
	//verify selected product page is displayed
			public void verifySelectedProductPageIsDisplayed() {
				String actualTitle = BaseTest.driver.getTitle();
				String expectedTitle = "Amazon Basics 8-Sheet Capacity, Cross-Cut Paper and Credit Card Shredder, 4.1 Gallon";
				Assert.assertEquals(actualTitle, expectedTitle, "Product page is verified:"+ expectedTitle +"is displayed");
				System.out.println("Amazon selected product page is displayed");
		    }
			
			//verify 8sheet is selected under size section
			public void verify8sheetSizeIsSelected(){
				BaseTest.driver.findElement(loc_btnSize).isDisplayed();
				Assert.assertTrue(BaseTest.driver.findElement(loc_btnSize).isSelected(),
						"8 sheet size button is not selected");
				System.out.println("Verify '8-sheet' size is selected");
			}
				

			//click on add to cart
			public void clickOnAddToCart(){
				BaseTest.driver.findElement(loc_btnAddToCart).isDisplayed();
				Assert.assertTrue(BaseTest.driver.findElement(loc_btnAddToCart).isDisplayed(),
						"Add to cart button is not displayed");
				System.out.println("Add to Cart is displayed");
				BaseTest.driver.findElement(loc_btnAddToCart).click();
				System.out.println("Click on Add to Cart");
			}
			
}
