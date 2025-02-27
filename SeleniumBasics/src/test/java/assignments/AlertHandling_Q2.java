package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandling_Q2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/alerts");

		driver.manage().window().maximize();

		WebElement button1 = driver.findElement(By.id("alertButton"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", button1);
		
		button1.click();
		
		System.out.println("Button1 alert Box Text: " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		WebElement button2 = driver.findElement(By.id("timerAlertButton"));
		button2.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		System.out.println("Button2 alert Box Text: " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		WebElement button3 = driver.findElement(By.id("confirmButton"));
		button3.click();
		System.out.println("Button3 alert Box Text: " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		WebElement button4 = driver.findElement(By.id("promtButton"));
		button4.click();
		driver.switchTo().alert().sendKeys("Devika");
		System.out.println("Button4 alert Box Text: " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

	}

}
