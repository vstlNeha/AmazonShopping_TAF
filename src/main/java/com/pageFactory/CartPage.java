package com.pageFactory;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.generic.BaseTest;

public class CartPage {

	By loc_hdrShoppingCart = By.xpath("//h1[contains(.,'Shopping Cart')]");
	By loc_noOfItemSubtotal = By.xpath("//span[@id='sc-subtotal-label-activecart'][contains(.,'Subtotal (1 item):')]");
	
	
	//verify shopping cart page is displayed
	public void verifyShoppingCartPageIsDisplayed() {
		BaseTest.driver.findElement(loc_hdrShoppingCart).isDisplayed();
		Assert.assertTrue(BaseTest.driver.findElement(loc_hdrShoppingCart).isDisplayed(),"Shopping cart page is not displayed");
		System.out.println("Verify Shopping cart page is displayed");
    }
	
	//verify no of items in subtotal
		public void verifyNoOfItemsInSubtotalIsDisplayed() {
			BaseTest.driver.findElement(loc_noOfItemSubtotal).isDisplayed();
			Assert.assertTrue(BaseTest.driver.findElement(loc_noOfItemSubtotal).isDisplayed(),"1 item in subtotal is not displayed");
			System.out.println("Verify 1 item in subtotal is displayed");
	    }
}
