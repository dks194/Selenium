package assignments;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		//url launch
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		//window maximize
		driver.manage().window().maximize();

		// parent handle
		String parentWindowHandle = driver.getWindowHandle();

		// Button1
		WebElement openNewWindowButton = driver.findElement(By.id("newWindowBtn"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", openNewWindowButton);

		openNewWindowButton.click();

		// handle all windows
		Set<String> allWindowHandle = driver.getWindowHandles();

		for (String windowHandle : allWindowHandle) {

			if (!windowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(windowHandle);

				driver.manage().window().maximize();

				WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));

				js.executeScript("arguments[0].scrollIntoView();", firstName);

				firstName.sendKeys("Devika");

				Actions actions = new Actions(driver);

				WebElement lastName = driver.findElement(By.id("lastName"));

				actions.moveToElement(lastName).click().sendKeys("M").build().perform();

				WebElement femaleRadioButton = driver.findElement(By.id("femalerb"));
				femaleRadioButton.click();

				WebElement englishCheckBox = driver.findElement(By.id("englishchbx"));
				englishCheckBox.click();

				WebElement email = driver.findElement(By.id("email"));
				email.sendKeys("abc@gmail.com");

				WebElement password = driver.findElement(By.id("password"));
				password.sendKeys("abc");

				WebElement registerButton = driver.findElement(By.id("registerbtn"));
				registerButton.click();

				WebElement message = driver.findElement(By.id("msg"));
				System.out.println("Text after registration : " + message.getText());
				System.out.println("Message Displayed : " + message.isDisplayed());

				break;
			}

		}

		// switch back to main window
		driver.switchTo().window(parentWindowHandle);
		System.out.println("Title of the parent window : " + driver.getTitle());

		WebElement headingParentWindow = driver.findElement(By.cssSelector(".entry-title"));
		System.out.println("Heading of parent : " + headingParentWindow.getText());

		driver.quit();
	}

}
