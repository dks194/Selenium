package selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload_Robot {

	public static void main(String[] args) throws AWTException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/upload");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// implicit wait

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
		//chooseFileButton.sendKeys(Keys.ENTER);

		js.executeScript("arguments[0].click();", chooseFileButton);
		
		Robot robot = new Robot();
		
		robot.setAutoDelay(2000);

		StringSelection filePath = new StringSelection("C:\\Users\\91949\\Desktop\\Obsqura\\SeleniumNotes.txt");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		//Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);

		//robot.delay(2);// 2 milliseconds

		robot.keyPress(KeyEvent.VK_V);

		//robot.delay(2);

		robot.keyRelease(KeyEvent.VK_CONTROL);

		//robot.delay(2);

		robot.keyRelease(KeyEvent.VK_V);

		//robot.delay(2);

		robot.keyPress(KeyEvent.VK_ENTER);

		//robot.delay(2);

		robot.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("File Uploaded");

	}

}
