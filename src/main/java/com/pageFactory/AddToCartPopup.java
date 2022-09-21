package com.pageFactory;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.generic.BaseTest;

public class AddToCartPopup {

	By loc_hdrAddedToCart = By.xpath("//div[@id='attachDisplayAddBaseAlert']//h4[contains(.,'Added to Cart')]");
	By loc_noOfItemAddedToCart = By.xpath("//span[@id='attach-accessory-cart-total-string'][contains(.,' (1 item): ')]");
	By loc_btnCart = By.xpath("//span[contains(.,'Proceed to checkout (1 item)')]/preceding::span[@class='a-button-text'][contains(.,'Cart')]");
	
	//verify added to cart popup is displayed
			public void verifyAddedToCartPopupIsDisplayed() {
				BaseTest.driver.findElement(loc_hdrAddedToCart).isDisplayed();
				Assert.assertEquals(BaseTest.driver.findElement(loc_hdrAddedToCart).isDisplayed(),"Added to Cart Popup is displayed");
				System.out.println("Added to Cart Popup is displayed");
		    }
			

			//verify 1 item is added to cart
					public void verifyNoOfItemsAddedToCart() {
						BaseTest.driver.findElement(loc_noOfItemAddedToCart).isDisplayed();
						Assert.assertTrue(BaseTest.driver.findElement(loc_noOfItemAddedToCart).isDisplayed(),"1 item Added to Cart Popup is not displayed");
						System.out.println("1 item Added to Cart Popup is displayed");
				    }
					

					//click on cart
							public void clickOnCartButton() {
								BaseTest.driver.findElement(loc_btnCart).isDisplayed();
								Assert.assertTrue(BaseTest.driver.findElement(loc_btnCart).isDisplayed(),"Cart button is not displayed");
								BaseTest.driver.findElement(loc_btnCart).click();
								System.out.println("Click on cart");
						    }
}
