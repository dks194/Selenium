package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class assignment1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://groceryapp.uniqassosiates.com/admin/login");

		driver.manage().window().maximize();

		WebElement username = driver.findElement(By.name("username"));

		Actions actions = new Actions(driver);

		actions.moveToElement(username).click().sendKeys("admin").sendKeys(Keys.TAB).sendKeys("admin").build()
				.perform();
		
		WebElement checkbox = driver.findElement(By.xpath("//label[@for='remember']"));
		checkbox.click();
		
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		
		System.out.println(button.getText());

	}

}
