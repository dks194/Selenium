package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsEg {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://selenium.qabible.in/index.php");
		
		driver.manage().window().maximize();
		
		List<WebElement> allTabs =  driver.findElements(By.cssSelector(".nav-link"));
		System.out.println(allTabs.size());
		
		
		for (WebElement individualTab : allTabs) {
			System.out.println(individualTab.getText()); 
		}
		
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		
		List<WebElement> alltextBox = driver.findElements(By.cssSelector("input"));
		
		int iterationCount = 0;
		
		System.out.println("\n"+alltextBox.size());
		
		for (WebElement eachTextBox : alltextBox) {
			eachTextBox.sendKeys("Sample text");
			System.out.println(iterationCount);
			iterationCount++;
		}
		System.out.println("total iteration : "+iterationCount);
		
		
		
		
		driver.close();
	}

}
