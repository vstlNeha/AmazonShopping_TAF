package com.scripts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonNew {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\src\\main\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();

		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("Amazon basics");
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

		String Expected_Title = "amazonbasics ";
		String Actual_Title = driver.getTitle();
		System.out.println(driver.getTitle());

		// our brand - from our brands
		driver.findElement(By.xpath("//span[text()='Our Brands']")).click();
		System.out.println("click on our brand");
		Thread.sleep(3000);
		String nextButtonClass = driver.findElement(By.xpath("//a[contains(@aria-label,'Go to next page')]"))
				.getAttribute("class");
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(10000);
		// js.executeScript("arguments[0].scrollIntoView(true);",
		// nextButtonClass);
		System.out.println("scrolled to next btn");

		Boolean blnStatus;
		while (!nextButtonClass.contains("disabled")) {
			try {

				blnStatus = driver
						.findElement(By
								.xpath("//span[text()='Amazon Basics 2 Ply Paper Towel - Flex-Sheets - 12 Value Rolls (Previously Solimo)']"))
						.isDisplayed();

			} catch (Exception e) {
				// TODO: handle exception
				blnStatus = false;
			}

			if (blnStatus) {
				System.out.println("Element Found break loop");
				break;
			} else {
				Thread.sleep(10000);
				js.executeScript("window.scrollBy(0,250)", "");
				Thread.sleep(10000);
				// js.executeScript("arguments[0].scrollIntoView(true);",
				// nextButtonClass);
				if (driver.findElement(By.xpath("//a[contains(@aria-label,'Go to next page')]")).isEnabled()) {
					driver.findElement(By.xpath("//a[contains(@aria-label,'Go to next page')]")).click();
					System.out.println("click on next button");

				}
			}

		}}
	
}
