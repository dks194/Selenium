	package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentDropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");

		driver.manage().window().maximize();

		// COURSE NAME DROPDOWN

		WebElement courseNameDropdown = driver.findElement(By.id("course"));
		Select selectCourseName = new Select(courseNameDropdown);

		System.out.println("The Course Name Dropdown is Multi Select Dropdown: " + selectCourseName.isMultiple()
				+ "\n");

		List<WebElement> courseNameOptions = selectCourseName.getOptions();

		System.out.println("Course Name dropdown options are: ");

		for (WebElement option : courseNameOptions) {
			System.out.println(option.getText());
		}

		selectCourseName.selectByValue("python");

		System.out.println("The selected option from Course Name dropdown is: "
				+ selectCourseName.getFirstSelectedOption().getText() + "\n");

		// IDE DROPDOWN

		WebElement ideNameDropdown = driver.findElement(By.id("ide"));
		Select selectIdeName = new Select(ideNameDropdown);

		System.out.println("The IDE Name Dropdown is Multi Select Dropdown: " + selectIdeName.isMultiple()
				+ "\n");

		selectIdeName.selectByIndex(0);
		selectIdeName.selectByValue("vs");
		selectIdeName.selectByVisibleText("NetBeans");

		System.out.println("The first selected option in IDE Name dropdown is : "
				+ selectIdeName.getFirstSelectedOption().getText() + "\n");

		List<WebElement> selectedOptionsIdeDropdown = selectIdeName.getAllSelectedOptions();

		System.out.println("IDE Name dropdown options are: ");

		for (WebElement selectedOption : selectedOptionsIdeDropdown) {
			System.out.println(selectedOption.getText());
			
		}

		driver.close();
	}
}
