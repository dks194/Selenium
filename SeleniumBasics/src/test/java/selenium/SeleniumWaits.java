package selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://selenium.qabible.in/javascript-alert.php");

		driver.manage().window().maximize();

		// IMPLICIT Wait - given after loading url or window maximize

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// OR
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// EXPLICIT wait obj created
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement simpleAlertButton = driver.findElement(By.className("btn-success"));

		// explicit wait

		/*
		 * can be used for buttons or links,ie for clickable elements.until the
		 * clickable element is located
		 */
		
		wait.until(ExpectedConditions.elementToBeClickable(simpleAlertButton));

		// can be applied for any element{the below 3}
		/*
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.className(
		 * "btn-success")));
		 * 
		 * wait.until(ExpectedConditions.visibilityOf(simpleAlertButton));
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(
		 * "btn-success")));
		 */
		// ******************************************
		
		wait.until(ExpectedConditions.alertIsPresent());
		simpleAlertButton.click();
		
		System.out.println(driver.switchTo().alert().getText());//to print the text in alert box in console
		driver.switchTo().alert().accept();
		
		WebElement confirmationAlertButton = driver.findElement(By.className("btn-warning"));
		
		//Fluent Wait
		//creating fluent wait object/instance-wait1
		FluentWait<WebDriver> wait1 = new FluentWait<>(driver)  
				.withTimeout(Duration.ofSeconds(10))  // Max wait time
                .pollingEvery(Duration.ofSeconds(1))  // Check every 1 second
                .ignoring(NoSuchElementException.class);  // Ignore this exception
		
		wait1.until(ExpectedConditions.elementToBeSelected(confirmationAlertButton));
		confirmationAlertButton.click();

	}

}
