package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload_Sendkeys {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/upload");

		driver.manage().window().maximize();
		
		WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
		chooseFileButton.sendKeys("C:\\Users\\91949\\Desktop\\Obsqura\\SeleniumNotes.txt");
		
		WebElement uploadButton = driver.findElement(By.id("file-submit"));
		uploadButton.click();
}
}