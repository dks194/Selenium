package selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload_RobotClass3 {
	public static void main(String[] args) throws InterruptedException, AWTException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement chooseFile = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", chooseFile);
		Thread.sleep(3000);

		// Set the file path to be uploaded
		String filePath = "C:\\Users\\91949\\Desktop\\Obsqura\\SeleniumNotes.txt"; // Change this path
		
		// Copy the file path to clipboard
		StringSelection selection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		// Use Robot class to handle the file upload dialog
		Robot robot = new Robot();

		// Press Ctrl + V (Paste the file path)
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// Press Enter to confirm file selection
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Wait for the upload process
		Thread.sleep(2000);

		// Click the upload button to submit the file
		driver.findElement(By.id("submitbutton")).click();

		// Close the browser
		Thread.sleep(3000);
		driver.quit();

	}
}
