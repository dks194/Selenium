package practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class assfindEl {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://selenium.qabible.in/index.php ");
		
		driver.manage().window().maximize();
		
		WebElement inputForm = driver.findElement(By.xpath("//a[@href='simple-form-demo.php'and contains(text(),'Input')]"));
		inputForm.click();
		
		List<WebElement> allButtons = driver.findElements(By.className("btn-primary"));
		System.out.println(allButtons.size());
		
		
		List<WebElement> allhyperLinks = driver.findElements(By.cssSelector(".list-group-item"));
		System.out.println(allhyperLinks.size());
		
		WebElement radioButton = driver.findElement(By.xpath("//a[text()='Radio Buttons Demo']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(radioButton).click().build().perform();
		
		
		
		List<WebElement> allRadioButtons = driver.findElements(By.className("form-check-input"));
		System.out.println(allRadioButtons.size());
		
		int button=1;
		
		for (WebElement eachradioButton : allRadioButtons) {
			eachradioButton.click();
			System.out.println(button+":"+eachradioButton.isSelected());
			button++;
		}
		
		
		
		
		
		
		driver.close();
	}

}
