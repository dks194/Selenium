package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ass_1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/ajax.html");

		driver.manage().window().maximize();

		System.out.println("URL : " + driver.getCurrentUrl());

		System.out.println("Title : " + driver.getTitle());
		
		WebElement yes = driver.findElement(By.id("yes"));
		System.out.println( yes.isSelected());
		
		WebElement no = driver.findElement(By.id("no"));
		System.out.println(no.isSelected());
		
		no.click();
		System.out.println(no.isSelected());
		
		driver.navigate().to("https://qalegend.com/restaurant/");
		
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("admin");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("password");
		
		WebElement login = driver.findElement(By.name("submit"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", login);
		
		WebElement heading = driver.findElement(By.cssSelector(".choose_store"));
		System.out.println(heading.getText());
		System.out.println(heading.getTagName());
		
		WebElement product = driver.findElement(By.xpath("//span[text()='Product']"));
		product.click();
		
		WebElement button = driver.findElement(By.className("btn-add"));
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", button);
		
		//js.executeScript("window.scrollBy(0,105000);");
		
		button.click();
		
		driver.close();

	}

}
