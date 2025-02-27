package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling_Q1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

		driver.manage().window().maximize();

		// Alert Box
		WebElement alertBox = driver.findElement(By.id("alertexamples"));
		alertBox.click();
		System.out.println("Alert Box Text: " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		// Confirm Box
		WebElement confirmBox = driver.findElement(By.id("confirmexample"));
		confirmBox.click();
		System.out.println("Confirm Box Text: " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		// Prompt Box
		WebElement promptBox = driver.findElement(By.id("promptexample"));
		promptBox.click();
		driver.switchTo().alert().sendKeys("Devika");
		System.out.println("Prompt Box Text: " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		driver.close();
	}

}
