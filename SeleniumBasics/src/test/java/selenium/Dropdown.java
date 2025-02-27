package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://selenium.qabible.in/select-input.php");

		driver.manage().window().maximize();
		
		WebElement dropdownSingle = driver.findElement(By.id("single-input-field"));
		Select select = new Select(dropdownSingle);
		System.out.println(select.isMultiple()); 
		
		
		select.selectByIndex(2);
		//select.selectByValue("Red");
		
		WebElement firstOption = select.getFirstSelectedOption();
		System.out.println("First Selected option "+firstOption.getText());
		
		List<WebElement> allOptions = select.getOptions();
		for (WebElement option : allOptions) {
			System.out.println(option.getText());
		}
		
		WebElement dropdownMulti = driver.findElement(By.id("multi-select-field"));
		Select select1 = new Select(dropdownMulti);
		System.out.println(select1.isMultiple());
		select1.selectByIndex(1);
		select1.selectByIndex(3);
		
		
		List<WebElement> allOptionsMulti = select1.getOptions();
		for (WebElement optionMulti : allOptionsMulti) {
			System.out.println(optionMulti.getText());
		}
		
		//To deselect
		select1.deselectAll();
		select.deselectByIndex(1);
		select1.deselectByValue("Yellow");
		select1.deselectByVisibleText("Green");
		
		
		
		
		

	}

}
