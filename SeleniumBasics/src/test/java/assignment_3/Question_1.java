package assignment_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question_1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/ajax.html");

		driver.manage().window().maximize();

		System.out.println("URL : " + driver.getCurrentUrl());

		System.out.println("TITLE : " + driver.getTitle());

		WebElement radioButtonStatus = driver.findElement(By.id("Yes"));
		System.out.println(radioButtonStatus.isSelected() + " : The radio button \"yes\" is DESELECTED by default ");

		WebElement radioButtonNo = driver.findElement(By.id("No"));
		radioButtonNo.click();
		System.out.println(radioButtonNo.isSelected() + " : The radio button \"no\" is SELECTED");

		driver.close();

	}

}
