package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentTable_Q1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/newtours/");
		
		driver.manage().window().maximize();
		
		WebElement hotelsLink = driver.findElement(By.xpath("//table[@border='2']/tbody/tr[3]/td[2]"));
		System.out.println("Hotels Link Text : "+hotelsLink.getText());
		
		WebElement specialsTableText = driver.findElement(By.xpath("//table[@width='270']/tbody/tr[4]/td[1]"));
		System.out.println("Text in specials table : "+specialsTableText.getText());
		
		List<WebElement> rowsNavigationBar = driver.findElements(By.xpath("//table[@border='2']/tbody/tr"));
		System.out.println("Rows count in navigation bar : "+rowsNavigationBar.size());
		
		List<WebElement> columnsNavigationBar = driver.findElements(By.xpath("//table[@border='2']/tbody/tr[1]/td"));
		System.out.println("Columns count in navigation bar : "+columnsNavigationBar.size());
		
		List<WebElement> rowsSpecialTable = driver.findElements(By.xpath("//table[@width='270']/tbody/tr"));
		System.out.println("Rows count in special table : "+rowsSpecialTable.size());
		
		List<WebElement> columnsSpecialTable = driver.findElements(By.xpath("//table[@width='270']/tbody/tr[1]/td"));
		System.out.println("Columns count in special table : "+columnsSpecialTable.size());
		

	}

}
