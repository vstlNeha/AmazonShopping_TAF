package com.generic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperFunctions {

			//set implicit wait
			public void setImplicitWait(int intWait) {
				try {
					BaseTest.driver.manage().timeouts().implicitlyWait(intWait,TimeUnit.SECONDS);
				}catch(Exception e) {
					e.printStackTrace();
				}}
			
			//set explicit wait for the visibility of element
			public void setWaitForElementToBeVisible(int intWait,By locator) {
				try {
			 WebDriverWait wait = new WebDriverWait(BaseTest.driver,intWait);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				}catch(Exception e) {
					e.printStackTrace();
				}}
			
			//set explicit wait for element to be clickable
			public void setWaitForElementToBeClickable(int intWait,By locator) {
				try {
			 WebDriverWait wait = new WebDriverWait(BaseTest.driver,intWait);
			 wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
				}catch(Exception e) {
					e.printStackTrace();
				}}
			
			
			//scroll to view for an element
			public void scrollToViewElement(By locator) {
				try {
					JavascriptExecutor scroll = (JavascriptExecutor)BaseTest.driver;
					WebElement Webelement = BaseTest.driver.findElement(locator);
					scroll.executeScript("arguments[0].scrollIntoView(true);",Webelement);
				}catch(Exception e) {
					e.printStackTrace();
				}}
			
			//click using action class
			public void clickOnWebElementUsingActions(By locator){
				WebElement Webelement = BaseTest.driver.findElement(locator);
                 Actions actions = new Actions(BaseTest.driver);
                 actions.moveToElement(Webelement).click().perform();
				}
			
}
