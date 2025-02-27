package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//https://www.hyrtutorials.com/p/frames-practice.html - url for practise
public class SwitchingCommands_iFrame {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/frames");

		driver.manage().window().maximize();

		// switch to frame using index
		// driver.switchTo().frame(4);

		// switch to frame using id or name
		// driver.switchTo().frame("frame1");

		// switch to frame by declaring it as a webelement-espicially this is done if there is no id and name atrribute
		WebElement iframe = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(iframe);

		WebElement heading = driver.findElement(By.id("sampleHeading"));

		System.out.println(heading.getText());

		
		// switch back to main page
		driver.switchTo().defaultContent();
	}

}
