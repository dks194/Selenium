package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;

public class BrowserLaunch {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		// System.setProperty("webdriver.edge.driver",
		// "C://Users//91949//Downloads//msedgedriver.exe");
		// WebDriver driver = new EdgeDriver();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.obsqurazone.com/");
		driver.manage().window().fullscreen();
		
		String title=driver.getTitle();
		System.out.println(title);
		
		String currentUrl=driver.getCurrentUrl();
		System.out.println(currentUrl);
		//driver.manage().window().minimize();

		//driver.quit();
		driver.close();// only closes the current window

	}

}
