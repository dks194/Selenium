package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.get("http://erp.qabible.in/login");

		driver.manage().window().maximize();

		String title = driver.getTitle();
		System.out.println(title);

		WebElement userNameTextBox = driver.findElement(By.name("user_name"));
		userNameTextBox.sendKeys("admin");

		WebElement passwordTextBox = driver.findElement(By.name("password"));
		passwordTextBox.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.className("btn-primary"));
		loginButton.click();
		
		driver.navigate().refresh();
		
		driver.navigate().to("https://qalegend.com/billing/public/login");
		
		String titleOfNavigatedPage = driver.getTitle();
		System.out.println(titleOfNavigatedPage);
		
		WebElement userNameTextBoxNavigatePage = driver.findElement(By.id("username"));
		userNameTextBoxNavigatePage.sendKeys("admin");
		
		WebElement passwordTextBoxNavigatedPage = driver.findElement(By.id("password"));
		passwordTextBoxNavigatedPage.sendKeys("123456");
		
		WebElement loginButtonNavigatedPage = driver.findElement(By.className("btn-primary"));
		loginButtonNavigatedPage.click();
		
		driver.close();
	}

}
