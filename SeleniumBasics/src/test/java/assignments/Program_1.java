package assignments;

//import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Program_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();

		driver.get("https://www.google.com/");

		driver.manage().window().maximize();

		driver.navigate().refresh();

		WebElement searchTextBox = driver.findElement(By.id("APjFqb"));
		searchTextBox.sendKeys("Apple Fruit");
		searchTextBox.sendKeys(Keys.ENTER);
		//searchTextBox.sendKeys(KeyEvent.VK_ENTER);

//		WebElement searchButton = driver.findElement(By.name("btnK"));
//		searchButton.click();

		String title = driver.getTitle();
		System.out.println(title);

		String url = driver.getCurrentUrl();
		System.out.println(url);

		driver.navigate().back();

		driver.close();
	}

}
