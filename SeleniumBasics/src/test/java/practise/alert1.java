package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class alert1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

		WebElement simplealert = driver.findElement(By.id("alertexamples"));
		simplealert.click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		WebElement prompt = driver.findElement(By.id("promptexample"));
		prompt.click();
		driver.switchTo().alert().sendKeys("Devika");
		driver.switchTo().alert().accept();

		driver.navigate().to("https://demoqa.com/alerts");

		WebElement btn1 = driver.findElement(By.id("alertButton"));
		js.executeScript("arguments[0].scrollIntoView();", btn1);
		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.visibilityOf(btn1));

		btn1.click();
		driver.switchTo().alert().accept();
		
		WebElement btn2 = driver.findElement(By.id("timerAlertButton"));
		btn2.click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
		
		driver.close();

	}

}
