package com.pageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.generic.BaseTest;
import com.generic.WrapperFunctions;

public class AmazonBasicsPage {

	WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	Actions actions = new Actions(BaseTest.driver);

	By loc_hdrAmazonBasics = By
			.xpath("//span[contains(text(),'amazon basics')]");
	By loc_hdrFromOurBrands = By
			.xpath("//div[@class='a-section']//div[@class='a-section a-spacing-small']//span[contains(.,'From Our Brands')]");
	By loc_checkboxOurBrands = By
			.xpath("//span[contains(.,'Our Brands')]/preceding::span[contains(.,'From Our Brands')]/following::input[@type='checkbox'][1]");
	By loc_btnNextPage = By
			.xpath("//a[contains(@aria-label,'Go to next page')]");
	By loc_listProducts = By
					.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']");
	By loc_imgProduct = By
			.xpath("//span[contains(text(),'Amazon Basics Vacuum Compression Storage Bags with Hand Pump - 15-Pack (2 X-Jumbo, 5 Jumbo, 4 Large, 4 Medium)')]");

	// verify amazon basics page
	public void verifyAmazonBasicsPageIsDisplayed() {
		BaseTest.driver.findElement(loc_hdrAmazonBasics).isDisplayed();
		Assert.assertTrue(BaseTest.driver.findElement(loc_hdrAmazonBasics)
				.isDisplayed(), "Amazon basics page is not displayed");
		System.out.println("Amazon basics page is displayed");
	}

	// verify from our brands header is displayed
	public void verifyFromOurBrandsHeaderIsDisplayed() {
		BaseTest.driver.findElement(loc_hdrFromOurBrands).isDisplayed();
		objWrapperFunctions.scrollToViewElement(loc_hdrFromOurBrands);
		Assert.assertTrue(BaseTest.driver.findElement(loc_hdrFromOurBrands)
				.isDisplayed(), "From our brands checkbox is not displayed");
		System.out.println("'From our brands' header is displayed");
	}

	// click on our brand checkbox
	public void clickOnOurBrandCheckbox() {
		BaseTest.driver.findElement(loc_checkboxOurBrands).isDisplayed();
		Assert.assertTrue(BaseTest.driver.findElement(loc_checkboxOurBrands)
				.isDisplayed(), "Our brands checkbox is not selected");
		objWrapperFunctions
				.clickOnWebElementUsingActions(loc_checkboxOurBrands);
		System.out
				.println("'Our brands' from 'From our brands' checkbox is selected");
	}

	// verify our brands checkbox is selected
	public void verifyOurBrandsCheckboxIsSelected() {
		objWrapperFunctions.setWaitForElementToBeVisible(60,
				loc_checkboxOurBrands);
		objWrapperFunctions.scrollToViewElement(loc_checkboxOurBrands);
		Assert.assertTrue(BaseTest.driver.findElement(loc_checkboxOurBrands)
				.isSelected(), "Our brands checkbox is not selected");
		System.out
				.println("Verify 'Our brands' from 'From our brands' checkbox is selected");
	}

	public void getListOfProducts() throws InterruptedException {
		System.out.println("Enter into getproductlist");
		List<WebElement> products = BaseTest.driver
				.findElements(loc_listProducts);
		for (WebElement product : products) {
			System.out.println(product.getText());
			if (product.getText().equals("Amazon Basics Vacuum Compression Storage Bags with Hand Pump - 15-Pack (2 X-Jumbo, 5 Jumbo, 4 Large, 4 Medium)")) {
				BaseTest.driver.findElement(loc_imgProduct).isDisplayed();
				objWrapperFunctions.scrollToViewElement(loc_imgProduct);
				objWrapperFunctions.setWaitForElementToBeClickable(60,
						loc_imgProduct);
				// break;
			} else {
				System.out.println("no");
			}
		}

		try {
			clickOnNextPage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOnNextPage() throws InterruptedException {
		Thread.sleep(3000);
		objWrapperFunctions.scrollToViewElement(loc_btnNextPage);
		Thread.sleep(3000);
		objWrapperFunctions.clickOnWebElementUsingActions(loc_btnNextPage);
		System.out.println("Click on next page: Next page gets loaded");
		BaseTest.driver.manage().timeouts()
				.pageLoadTimeout(60, TimeUnit.SECONDS);
		getListOfProducts();
	}
}
