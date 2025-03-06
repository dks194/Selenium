package practise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Sample {

	WebDriver driver;

	@Test(priority = 0)
	public void verifyTheExactPageIsOpensWhileHittingTheURL() {
		System.out.println("Url of the page : "+driver.getCurrentUrl());
	}
	
	@Test(priority = 1)
	public void verifyTheLogoIsDisplayedOrNot() {
		WebElement logo = driver.findElement(By.xpath("(//img[@src='images/logo.png'])[1]"));
		System.out.println("Logo is displayed : "+logo.isDisplayed());
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/radio-button-demo.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}
