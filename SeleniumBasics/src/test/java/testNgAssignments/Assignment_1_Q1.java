package testNgAssignments;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Assignment_1_Q1 {

	WebDriver driver;

	@Test(priority = 1)
	public void verifyTheURLOfThePage() {

		String actualResult = driver.getCurrentUrl();
		String expectedResult = "http://demo.guru99.com/test/ajax.html";

		SoftAssert softAsassesert = new SoftAssert();
		softAsassesert.assertEquals(actualResult, expectedResult);

		System.out.println("URL of the page : " + driver.getCurrentUrl());
	}

	@Test(priority = 2)
	public void verifyTheTitleOfThePage() {
		String actualResult = driver.getTitle();
		String expectedResult = "Ajax Test";
		Assert.assertEquals(actualResult, expectedResult);

		System.out.println("Title of the page : " + driver.getTitle());
	}

	@Test(priority = 3)
	public void verifyTheCountOfRadioButtonsDisplayedOnThePage() {
		List<WebElement> radioButtons = driver.findElements(By.cssSelector("p label"));
		int actualResult = radioButtons.size();
		int expectedResult = 2;
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Count of radio buttons : " + radioButtons.size());
	}

	@Test(priority = 4)
	public void verifyTheCountOfButtonsDisplayedOnThePage() {
		List<WebElement> buttons = driver.findElements(By.xpath("//input[@type='reset' or @type='submit']"));
		int actualResult = buttons.size();
		int expectedResult = 2;
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Count of buttons : " + buttons.size());
	}

	@Test(priority = 5)
	public void verifyTheYesRadioButtonIsDeselectedByDefault() {
		WebElement yesRadioButton = driver.findElement(By.id("yes"));
		boolean actualResult = false;
		Assert.assertFalse(actualResult);
		System.out.println("Yes Radio Button is selected : " + yesRadioButton.isSelected());
	}

	@Test(priority = 6)
	public void verifyThatNoRadioButtonIsSelectedOrNotAfterClickingOnIt() {
		WebElement noRadioButton = driver.findElement(By.id("no"));
		noRadioButton.click();
		boolean actualResult = true;
		Assert.assertTrue(actualResult);
		System.out.println("No Radio Button is selected : " + noRadioButton.isSelected());
	}
	

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/ajax.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

	/*
	 * @BeforeMethod public void beforeMethod() { driver = new ChromeDriver();
	 * driver.manage().window().maximize();
	 * driver.get("http://demo.guru99.com/test/ajax.html");
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); }
	 * 
	 * @AfterMethod public void afterMethod() { driver.quit(); }
	 */

}
