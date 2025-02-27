package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		
		driver.manage().window().maximize();
		
		driver.navigate().refresh();
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		WebElement valueATextbox = driver.findElement(By.id("value-a"));
		valueATextbox.sendKeys("10");
		
		WebElement valueBTextbox = driver.findElement(By.id("value-b"));
		valueBTextbox.sendKeys("15");
		
		WebElement getTotalButton = driver.findElement(By.id("button-two"));
		getTotalButton.click();
	}

}
