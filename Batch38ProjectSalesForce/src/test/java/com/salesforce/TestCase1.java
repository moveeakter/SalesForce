package com.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestCase1 {

	WebDriver driver;

	@Test
	public void tc_1() {
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// validating the homepage of salesforce that salesforce word id there or not
		WebElement salesForceLogo = driver.findElement(By.id("logo"));

		if (salesForceLogo.isDisplayed()) {
			System.out.println("Logo is Displayed");

		} else {
			System.out.println("Logo is not Displayed");

		}
		driver.findElement(By.id("username")).sendKeys("moveeakter2000@gmail.com");
		WebElement passWordField = driver.findElement(By.id("password"));
		passWordField.clear();
		passWordField.sendKeys("");
		driver.findElement(By.id("Login")).click();
		String errorMessage = driver.findElement(By.id("error")).getText();
		System.out.println(errorMessage);
		// Assert.assertEquals("Please enter your password.", errorMessage);
		String actualErrorMessage = "Please enter your password.";
		String expectedErrorMessage = driver.findElement(By.id("error")).getText();
		if (actualErrorMessage.equals(expectedErrorMessage)) {

			System.out.println("Error message is displayed then Test case Passed ");
		} else {
			System.out.println("Error message is not displayed then Test case Failed ");
		}
		
		driver.quit();
	}

}
