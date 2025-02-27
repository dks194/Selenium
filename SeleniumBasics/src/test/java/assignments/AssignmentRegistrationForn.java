package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentRegistrationForn {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/newtours/register.php");

		driver.manage().window().maximize();

		// Contact Information

		WebElement firstNameTextBox = driver.findElement(By.name("firstName"));
		firstNameTextBox.sendKeys("John");

		WebElement lastNameTextBox = driver.findElement(By.name("lastName"));
		lastNameTextBox.sendKeys("Tom");

		WebElement phoneTextBox = driver.findElement(By.name("phone"));
		phoneTextBox.sendKeys("+22 445 678");

		WebElement emailTextBox = driver.findElement(By.id("userName"));
		emailTextBox.sendKeys("johntom@gmail.com");

		// Mailing Information

		WebElement addressTextBox = driver.findElement(By.name("address1"));
		addressTextBox.sendKeys("Villa 21 ,SunShine apartments");

		WebElement cityTextBox = driver.findElement(By.name("city"));
		cityTextBox.sendKeys("Baker Island");

		WebElement stateTextBox = driver.findElement(By.name("state"));
		stateTextBox.sendKeys("Figi");

		WebElement postalcodeTextBox = driver.findElement(By.name("postalCode"));
		postalcodeTextBox.sendKeys("654 789 68");

		WebElement countryDropdown = driver.findElement(By.name("country"));

		Select selectCountry = new Select(countryDropdown);
		selectCountry.selectByValue("ARMENIA");

		// User Information

		WebElement userNameTextBox = driver.findElement(By.id("email"));
		userNameTextBox.sendKeys("admin");

		WebElement passwordTextBox = driver.findElement(By.name("password"));
		passwordTextBox.sendKeys("admin123");

		WebElement confirmPasswordTextBox = driver.findElement(By.name("confirmPassword"));
		confirmPasswordTextBox.sendKeys("admin123");

		WebElement submitButton = driver.findElement(By.name("submit"));
		submitButton.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement message = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//font[contains(text(),'Thank you for registering')]")));
		
		System.out.println("Displayed Text: " + message.getText());

		System.out.println("The message displayed : " + message.isDisplayed());

		WebElement signin = driver.findElement(By.xpath("//a[@href='login.php']"));
		signin.click();

		System.out.println("URL of the page after clicking sign-in: " + driver.getCurrentUrl());

		driver.close();
	}

}
