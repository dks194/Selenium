package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		driver.manage().window().maximize();

		WebElement messageTextBox = driver.findElement(By.id("single-input-field"));
		messageTextBox.sendKeys("This is a Sample Message");

//		WebElement showMessageButton = driver.findElement(By.xpath("//button[text()='Show Message']"));
//		showMessageButton.click();
		
		WebElement showMessageButton = driver.findElement(By.cssSelector("#button-one"));
		showMessageButton.click();
		
		WebElement displayedMessage = driver.findElement(By.id("message-one"));
		// String message=displayedMessage.getText();
		// System.out.println(message);
		System.out.println(displayedMessage.getText());

		System.out.println(displayedMessage.getTagName());

		System.out.println(displayedMessage.getAttribute("id"));

		messageTextBox.clear();
		messageTextBox.sendKeys("Message after clearing");

		driver.navigate().to("https://selenium.qabible.in/form-submit.php");
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		submitButton.submit();

		String cssProp = submitButton.getCssValue("background-color");
		System.out.println("Background colour of submit button is : " + cssProp);

		Point p = submitButton.getLocation();
		System.out.println(p);
		
		//Dimension d = 
		System.out.println(submitButton.getSize());
		
		System.out.println(submitButton.getText());
		boolean isDisplayed=submitButton.isDisplayed();
		System.out.println("Element display : "+isDisplayed);
		
		WebElement b = driver.findElement(By.id("invalidCheck"));
		b.click();
		
		boolean bIsSelected=submitButton.isDisplayed();
		System.out.println("Element selected : "+bIsSelected);
		

	}

}
