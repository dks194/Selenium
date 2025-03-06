package testNgAssignments;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;

public class Assignment_1_Q2 {

	WebDriver driver;

	@Test(priority = 1)
	public void verify_That_Exact_App_Opens_While_Hitting_The_URL() {
		WebElement pageHeading = driver.findElement(By.xpath("//h1[text()='Login']"));
		// System.out.println("Heading of the page : " + pageHeading.getText());
		String expectedResult = "Login1";
		String actualResult = pageHeading.getText();
		// Hard Assert
		 Assert.assertEquals(actualResult, expectedResult);

		// SoftAssert
		/*
		 * SoftAssert softAssert = new SoftAssert();
		 * softAssert.assertEquals(actualResult, expectedResult);
		 * softAssert.assertAll();
		 */
		System.out.println("Heading of the page : " + pageHeading.getText());
		//softAssert.assertAll();-always provide in the last line
		
	}

	@Test(priority = 2)
	public void verify_That_Logo_Is_Displayed_Or_Not_In_The_Login_Page() {
		WebElement logo = driver.findElement(By.xpath("//img[@alt='logo']"));
		//boolean expectedResult = true;
		boolean actualResult = logo.isDisplayed();
		//Assert.assertEquals(actualResult, expectedResult);
		Assert.assertTrue(actualResult);
		System.out.println("Logo is displayed : " + logo.isDisplayed());
	}

	@Test(priority = 3)
	public void verify_Successful_Login() {
		WebElement userName = driver.findElement(By.cssSelector("[placeholder='Username']"));
		userName.sendKeys("admin");
		WebElement password = driver.findElement(By.cssSelector("[placeholder='Password'"));
		password.sendKeys("password");
		WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
		loginButton.click();

		WebElement chooseAStoreHeading = driver.findElement(By.cssSelector(".choose_store"));
		System.out.println("Heading : " + chooseAStoreHeading.getText());
	}

	@Test(priority = 4)
	public void verify_Unsuccessful_Login_By_Invalid_Username_And_Valid_Password() {
		WebElement userName = driver.findElement(By.cssSelector("[placeholder='Username']"));
		userName.sendKeys("adm");
		WebElement password = driver.findElement(By.cssSelector("[placeholder='Password'"));
		password.sendKeys("password");
		WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
		loginButton.click();

		System.out.println("Unsuccessful Login;Current Url : " + driver.getCurrentUrl());
	}

	@Test(priority = 5)
	public void verify_Unsuccessful_Login_By_Valid_Username_And_Invalid_Password() {
		WebElement userName = driver.findElement(By.cssSelector("[placeholder='Username']"));
		userName.sendKeys("admin");
		WebElement password = driver.findElement(By.cssSelector("[placeholder='Password'"));
		password.sendKeys("pass");
		WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
		loginButton.click();

		System.out.println("Unsuccessful Login;Current Url : " + driver.getCurrentUrl());
	}

	@Test(priority = 6)
	public void verify_Unsuccessful_Login_By_Invalid_Username_And_Invalid_Password() {
		WebElement userName = driver.findElement(By.cssSelector("[placeholder='Username']"));
		userName.sendKeys("adm");
		WebElement password = driver.findElement(By.cssSelector("[placeholder='Password'"));
		password.sendKeys("pass");
		WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
		loginButton.click();

		System.out.println("Unsuccessful Login; Current Url : " + driver.getCurrentUrl());
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qalegend.com/restaurant/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
