package practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.guru99.com/test/newtours/");
		
		List<WebElement> rowsSide = driver.findElements(By.xpath("//table[@border='2']/tbody/tr"));
		System.out.println(rowsSide.size());
		
		List<WebElement> columnSide = driver.findElements(By.xpath("//table[@border='2']/tbody/tr[1]/td"));
		System.out.println(columnSide.size());
		
		WebElement sideBarMenu = driver.findElement(By.xpath("//table[@border='2']/tbody/tr[4]/td[2]"));		
		System.out.println(sideBarMenu.getText());
		
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@width='270']/tbody/tr"));
		System.out.println(rows.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//table[@width='270']/tbody/tr[2]/td"));
		System.out.println(columns.size());
		
		WebElement specialFlightsTable = driver.findElement(By.xpath("//table[@width='270']/tbody/tr[4]/td[1]"));		
		System.out.println(specialFlightsTable.getText());
		
		
	}

}
