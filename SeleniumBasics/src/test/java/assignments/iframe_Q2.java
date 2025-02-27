package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class iframe_Q2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 800);");

		WebElement frame = driver.findElement(By.id("frm1"));
		driver.switchTo().frame(frame);

		WebElement courseNameDropdown = driver.findElement(By.cssSelector("select[id='course']"));

		Select courseName = new Select(courseNameDropdown);
		courseName.selectByIndex(3);
		System.out.println("The selected course name : " + courseName.getFirstSelectedOption().getText());

		driver.switchTo().defaultContent();

		js.executeScript("window.scrollBy(0, 800);");

		WebElement frame2 = driver.findElement(By.id("frm2"));
		driver.switchTo().frame(frame2);

		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("Devika");
		System.out.println("Entered first name: " + firstName.getAttribute("value"));

		driver.switchTo().defaultContent();

	}

}
