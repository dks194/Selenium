package selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://way2automation.com/way2auto_jquery/frames-and-windows.php#load_box");

		driver.manage().window().maximize();

		// get parent window handle
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println(parentWindowHandle);

		WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='frames-windows/defult1.html']"));
		driver.switchTo().frame(frame1);

		WebElement newBrowserTab = driver.findElement(By.cssSelector("div.farme_window a"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", newBrowserTab);

		Thread.sleep(1000);

		driver.switchTo().defaultContent();

		// get all windows handles-all windows opened during execution
		Set<String> allWindowsHandles = driver.getWindowHandles();
		System.out.println(allWindowsHandles);

		for (String windowHandle : allWindowsHandles) {

			/*
			 * if (windowHandle!=parentWindowHandle) {
			 * driver.switchTo().window(windowHandle);
			 * 
			 * System.out.println("Title of child window: " + driver.getTitle());
			 * System.out.println("url of child window : " + driver.getCurrentUrl());
			 * 
			 * WebElement newBrowserTab1 =
			 * driver.findElement(By.cssSelector("div.farme_window a"));
			 * System.out.println("Child Text : " + newBrowserTab1.getText());
			 * 
			 * break; }
			 */
			if (!windowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(windowHandle);

				System.out.println("Title of child window: " + driver.getTitle());
				System.out.println("url of child window : " + driver.getCurrentUrl());

				WebElement newBrowserTab1 = driver.findElement(By.cssSelector("div.farme_window a"));
				System.out.println("Child Text : " + newBrowserTab1.getText());

				break;
			}
		}

		Thread.sleep(2000);
		
		//switching back to parent window
		driver.switchTo().window(parentWindowHandle);
		System.out.println("Title of parent window : " + driver.getTitle());

		Thread.sleep(1000);

		driver.quit();

	}

}
