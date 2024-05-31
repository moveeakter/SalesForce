package com.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

	WebDriver driver;

	public void tc_2() {
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// validating the homepage of salesforce that salesforce word id there or not
		WebElement salesForceLogo = driver.findElement(By.id("logo"));

		if (salesForceLogo.isDisplayed()) {
			System.out.println("Logo is Displayed");

		} else {
			System.out.println("Logo is not Displayed");

		}
		// sending user name

		driver.findElement(By.id("username")).sendKeys("moveeakter2000@gmail.com");
		// sending password to the password field
		WebElement passWordField = driver.findElement(By.id("password"));
		passWordField.sendKeys("Movee123");
		// clicking on the Login Btn
		driver.findElement(By.id("Login")).click();
		// validating the user name is there
		String usrName = driver.findElement(By.id("userNavLabel")).getText();
		System.out.println(usrName);
		if (usrName.equals("Movee Akter")) {
			System.out.println("user name is displayed then test case is passed");
		} else {
			System.out.println("user name is not displayed then test case is failed");
		}
		
		driver.quit();

	}
}
