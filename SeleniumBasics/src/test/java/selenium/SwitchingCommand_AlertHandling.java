package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingCommand_AlertHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://selenium.qabible.in/javascript-alert.php");

		driver.manage().window().maximize();

		WebElement simpleAlertButton = driver.findElement(By.className("btn-success"));
		simpleAlertButton.click();
		System.out.println(driver.switchTo().alert().getText());//to print the text in alert box in console
		driver.switchTo().alert().accept();

		WebElement confirmationAlertButton = driver.findElement(By.className("btn-warning"));
		confirmationAlertButton.click();
		driver.switchTo().alert().dismiss();

		WebElement promptButton = driver.findElement(By.cssSelector("button[class='btn btn-danger']"));
		promptButton.click();
		System.out.println("Prompt Button Text : "+driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("Sample");
		driver.switchTo().alert().accept();
		
		

	}

}
