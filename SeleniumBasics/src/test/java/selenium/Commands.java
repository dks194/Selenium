package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Commands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		String title = driver.getTitle();
		System.out.println(title);

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		// navigation commands

		// to - navigate from google to amazon - navigate from one page to another
		//driver.get("https://www.amazon.in/");
		driver.navigate().to("https://www.amazon.in/");

		// Or we can assign the Url in a string and can provide the variable name
		//String urlAmazon = "https://www.amazon.in/";
		//driver.navigate().to(urlAmazon);
		
		//back
		driver.navigate().back();
		
		//to refresh the page
		//driver.navigate().refresh();
		
		//forward
		driver.navigate().forward();
		
		
		
		
		

	}

}
