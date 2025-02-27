package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iframe_Q1 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://way2automation.com/way2auto_jquery/frames-and-windows.php#load_box");

		driver.manage().window().maximize();

		WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='frames-windows/defult1.html']"));
		driver.switchTo().frame(frame1);

		WebElement text = driver.findElement(By.cssSelector("div.farme_window a"));

		System.out.println("The text inside iframe : " + text.getText());

		System.out.println("Value of the href attribute : " + text.getAttribute("href"));

		System.out.println("Tagname : " + text.getTagName());

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", text);

		driver.switchTo().defaultContent();

		driver.quit();
	}

}
