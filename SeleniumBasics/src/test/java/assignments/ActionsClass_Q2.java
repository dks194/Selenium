package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class ActionsClass_Q2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://selenium.qabible.in/simple-form-demo.php");

		driver.manage().window().maximize();

		WebElement valueATextBox = driver.findElement(By.id("value-a"));

		Actions actions = new Actions(driver);

		actions.moveToElement(valueATextBox).click().sendKeys("10")
				.sendKeys(Keys.TAB)
				.sendKeys("25")
				.sendKeys(Keys.TAB)
				.sendKeys(Keys.ENTER)
				.build()
				.perform();

		WebElement message = driver.findElement(By.id("message-two"));
		System.out.println("Message : " + message.getText());

		driver.close();
	}

}
