package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://selenium.qabible.in/table-pagination.php");

		driver.manage().window().maximize();

		//WebElement table = driver.findElement(By.xpath("//table[@id='dtBasicExample']"));

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='dtBasicExample']/tbody/tr"));
		System.out.println(rows.size());

//		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='dtBasicExample']/thead/tr/th"));
		List<WebElement> columns = rows.get(0).findElements(By.tagName("td"));
		System.out.println("Columns: " + columns.size());

		List<WebElement> headings = driver.findElements(By.xpath("//table[@id='dtBasicExample']/thead/tr"));

		for (WebElement heading : headings) {
			System.out.println(heading.getText());

		}

		WebElement salary = driver.findElement(By.xpath("//table[@id='dtBasicExample']/thead/tr/th[6]"));
		System.out.println(salary.getText());
		System.out.println("********************************************");
		System.out.println("********************************************");

		 
		for (WebElement row : rows) {
			System.out.println(row.getText()+"  |  ");

		}

		/*
		 * for (WebElement row : rows) { List<WebElement> col =
		 * row.findElements(By.tagName("td"));
		 * 
		 * for (WebElement c : col) {
		 * 
		 * System.out.println(c.getText() + "  |  "); } System.out.println();
		 * 
		 * }
		 */

	}

}
