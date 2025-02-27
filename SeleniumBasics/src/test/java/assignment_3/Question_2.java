package assignment_3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Question_2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://qalegend.com/restaurant/");

		driver.manage().window().maximize();

		WebElement userNameTextbox = driver.findElement(By.xpath("//input[@name='username']"));
		userNameTextbox.sendKeys("admin");

		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@name='password']"));
		passwordTextbox.sendKeys("password");

		WebElement loginSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
		loginSubmit.submit();

		WebElement getTextChooseAStore = driver.findElement(By.xpath("//h1[text()=' Choose a store ']"));
		System.out.println("Text : " + getTextChooseAStore.getText());

		WebElement productTab = driver.findElement(By.xpath("//a[@href='https://qalegend.com/restaurant/products']"));
		productTab.click();

		WebElement addProductButton = driver.findElement(By.xpath("//button[text()='Add Product']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", addProductButton);

		addProductButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement codeTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ProductCode")));
		codeTextbox.sendKeys("qwer123");

		WebElement nameTextbox = driver.findElement(By.id("ProductName"));
		nameTextbox.sendKeys("Laptop");

		WebElement purchasePriceTextbox = driver.findElement(By.id("PurchasePrice"));
		purchasePriceTextbox.clear();
		purchasePriceTextbox.sendKeys("85000");

		WebElement priceTextbox = driver.findElement(By.id("Price"));
		priceTextbox.sendKeys("78000");

		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Submit')]"));
		submitButton.submit();

		
		WebElement submitButton2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='updatestock()']")));
		submitButton2.click();

		WebElement searchTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search']")));
		searchTextbox.sendKeys("Laptop");
		
		driver.navigate().to("https://qalegend.com/restaurant/");

		driver.close();
	}

}
