package practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");

		WebElement singleSelect = driver.findElement(By.id("course"));
		Select courseName = new Select(singleSelect);

		courseName.selectByIndex(3);
		System.out.println(courseName.getFirstSelectedOption().getText());
		System.out.println(courseName.isMultiple());

		List<WebElement> allCourseNames = courseName.getOptions();
		for (WebElement courses : allCourseNames) {
			System.out.println(courses.getText());
		}

		// IDE Dropdown
		WebElement ideDrop = driver.findElement(By.id("ide"));
		Select ideDropdown = new Select(ideDrop);
		ideDropdown.selectByIndex(0);
		ideDropdown.selectByIndex(1);
		ideDropdown.selectByIndex(2);
		System.out.println(ideDropdown.getFirstSelectedOption().getText());

		List<WebElement> allmultiselect = ideDropdown.getAllSelectedOptions();
		for (WebElement option : allmultiselect) {
			System.out.println(option.getText());
		}

	}

}
