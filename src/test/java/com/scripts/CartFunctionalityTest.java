package com.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.generic.Constants;
import com.pageFactory.AmazonBasicsPage;
import com.pageFactory.HomePage;

public class CartFunctionalityTest extends BaseTest{

	private HomePage objHomePage;
	private AmazonBasicsPage objAmazonBasicsPage;
	
	       // Initialize Views
			public void initializeViewsAndPages() {
				objHomePage=new HomePage();
				objAmazonBasicsPage=new AmazonBasicsPage();
			}

	@BeforeClass
	public void initializeEnvironment() {
		initialiseWebEnvironment();
		this.initializeViewsAndPages();
	}
	
	/*@AfterClass
	public void tearDownEnvironment(){
		teardown();
		}
	*/
	
	@Test
	public void validateAddToCartFunctionality() throws InterruptedException {
		
		objHomePage.verifyAmazonHomePageIsDisplayed();
		objHomePage.searchAllProduct(Constants.strSearchAmazonBasics);
		objHomePage.clickOnSearchAllProduct();
		objHomePage.clickOnAmazonBasicsCheckBox();
		objHomePage.verifyAmazonBasicsIsDisplayed();
		objAmazonBasicsPage.verifyFromOurBrandsHeaderIsDisplayed();
		objAmazonBasicsPage.clickOnOurBrandCheckbox();
		objAmazonBasicsPage.verifyOurBrandsCheckboxIsSelected();
		objAmazonBasicsPage.getListOfProducts();
		
	}
}
