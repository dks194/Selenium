package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentFindElements {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get(" https://selenium.qabible.in/index.php");

		driver.manage().window().maximize();

		WebElement inputFormTab = driver.findElement(By.cssSelector("a[href='simple-form-demo.php']"));
		inputFormTab.click();

		List<WebElement> allButtons = driver.findElements(By.cssSelector(".btn-primary"));
		System.out.println("Total number of buttons in InputForm : " + allButtons.size());

		List<WebElement> allHyperlinks = driver.findElements(By.cssSelector(".list-group-item a"));
		System.out.println("Total count of hyperlinks in the InputForm page : " + allHyperlinks.size());

		WebElement radioButtonsDemo = driver.findElement(By.xpath("//a[@href='radio-button-demo.php']"));
		radioButtonsDemo.click();

		List<WebElement> allRadioButtons = driver.findElements(By.cssSelector("input"));
		System.out.println("Total count of radio buttons : " + allRadioButtons.size());

		int buttonNo = 1;

		for (WebElement radioButton : allRadioButtons) {
			radioButton.click();

			System.out.println("Button " + buttonNo + " is selected : " + radioButton.isSelected());
			buttonNo++;
		}

		driver.close();

	}

}
