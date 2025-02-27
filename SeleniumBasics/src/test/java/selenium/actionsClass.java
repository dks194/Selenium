package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsClass {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://selenium.qabible.in/simple-form-demo.php");

		driver.manage().window().maximize();
		
		//Keyboard event
		
		WebElement messageTextBox = driver.findElement(By.id("single-inpur-field"));
		
		Actions actions = new Actions(driver);
		actions.click(messageTextBox).perform();
		
		actions.sendKeys("Sample").perform();
		actions.keyDown(Keys.TAB).perform();//pressing
		actions.keyUp(Keys.TAB).perform();//releasing the finger
		
//		actions.keyDown(Keys.ENTER).perform();
//		actions.keyUp(Keys.ENTER).perform();
		
		actions.sendKeys(Keys.ENTER).perform();//click to an element using send keys
		//actions.sendKeys(elementName,Keys.ENTER).perform();//instead of click ths can also be used
		
		//Ctrl+A- to be cleared in file upload class
		/*
		 * actions.keyDown(Keys.CONTROL); actions.keyDown()
		 */
		
		
		//actions.click(messageTextBox).sendKeys("tftyf").keyDown(Keys.TAB).keyUp(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		
		//Mouse Actions
		WebElement datePickerTab = driver.findElement(By.xpath("//a[@href='date-picker.php']"));
		Actions actions1 = new Actions(driver);
		
		actions1.moveToElement(datePickerTab).click().build().perform();//mouse hover
		//actions1.moveToElement(datePickerTab).contextClick().build().perform();//right click
		actions1.moveToElement(datePickerTab).doubleClick().build().perform();//double click
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
