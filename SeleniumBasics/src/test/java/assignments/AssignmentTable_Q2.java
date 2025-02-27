package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AssignmentTable_Q2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://groceryapp.uniqassosiates.com/admin/login");

		driver.manage().window().maximize();

		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");

		WebElement signInButton = driver.findElement(By.className("btn-dark"));
		signInButton.click();

		List<WebElement> allDashboardTiles = driver.findElements(By.cssSelector(".bg-info"));
		System.out.println("Dashboard tiles count : " + allDashboardTiles.size());

		WebElement manageProducts = driver.findElement(By.xpath("//li[@class='nav-item'][5]"));
		manageProducts.click();

		WebElement manageProdutsPageTitle = driver.findElement(By.cssSelector(".text-dark"));
		System.out.println("Heading of Manage Products page: " + manageProdutsPageTitle.getText());

		WebElement searchButton = driver.findElement(By.xpath("//a[@href='javascript:void(0)']"));
		searchButton.click();

		WebElement productCodeTextBox = driver.findElement(By.xpath("//input[@placeholder='Product Code']"));

		Actions actions = new Actions(driver);

		actions.moveToElement(productCodeTextBox).click().sendKeys("467").sendKeys(Keys.ENTER).build().perform();

		WebElement productName = driver.findElement(By.xpath("//table/tbody/tr/td[1]"));
		System.out.println("Product Name : " + productName.getText().replaceAll("P\\d+", "").trim());

		driver.close();

	}

}
