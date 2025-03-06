package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment_2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();

		WebElement userNameTextBox = driver.findElement(By.name("username"));
		userNameTextBox.clear();
		userNameTextBox.sendKeys("admin");

		WebElement passwordTextBox = driver.findElement(By.xpath("//input[starts-with(@name,'pass')]"));
		passwordTextBox.clear();
		passwordTextBox.sendKeys("admin");

		//WebElement checkbox = driver.findElement(By.xpath("//label[@for='remember']"));
		//checkbox.click();
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='remember']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", checkbox);
		

		WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
		signInButton.click();

		WebElement sideBarAdmin = driver.findElement(By.xpath("//a[text()=' Admin' and @class='d-block']"));

		String sideAdminText = sideBarAdmin.getText();
		System.out.println("Sidebar Admin Details :\n" + "text : " + sideAdminText);

		String sideAdminAttribute = sideBarAdmin.getAttribute("href");
		System.out.println("attribute : " + sideAdminAttribute);

		String sideAdminTagname = sideBarAdmin.getTagName();
		System.out.println("tagname : " + sideAdminTagname + "\n");

		WebElement dropdownAdmin = driver.findElement(By.xpath("//a[@data-toggle='dropdown']"));

		System.out.println("Dropdown Admin Details : \n" + "text : " + dropdownAdmin.getText());
		System.out.println("attribute : " + dropdownAdmin.getAttribute("href"));
		System.out.println("tagname : " + dropdownAdmin.getTagName());
		

	}

}
