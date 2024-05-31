package com.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase4_A {

	WebDriver driver;

	@Test
	public void tc_4() {
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// validating the homepage of salesforce that salesforce word id there or not
		WebElement salesForceLogo = driver.findElement(By.id("logo"));

		// sending user name

		driver.findElement(By.id("username")).sendKeys("moveeakter2000@gmail.com");
		// clicking on the forgot password link
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		// validating the forgot password message
		WebElement forgotMessage = driver.findElement(By.id("header"));
		if (forgotMessage.isDisplayed()) {
			System.out.println("Forgot Message is Displayed");

		} else {
			System.out.println("Forgot Message is not Displayed");

		}
		// checking the username field in the forgot password link
		driver.findElement(By.id("un")).sendKeys("moveeakter200@gmail.com");
		// clicking on the continue button
		driver.findElement(By.id("continue")).click();
		// validating the check my email message
		WebElement checkEmail = driver.findElement(By.className("mb12"));
		if (checkEmail.isDisplayed()) {
			System.out.println("Check email message is displayed, then the test case has passed");

		} else {
			System.out.println("Check emial message is not displayed, the test case has failed");

		}

		driver.quit();

	}
}
