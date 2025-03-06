package practise;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tables_2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://groceryapp.uniqassosiates.com/admin/login");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement username = driver.findElement(By.name("username"));
		Actions actions = new Actions(driver);
		actions. click(username).sendKeys("admin").sendKeys(Keys.TAB).sendKeys("admin").sendKeys(Keys.ENTER). build().perform();
 
//		WebElement btn = driver.findElement(By.className("btn-dark"));
//		btn.click();
		
		
		List<WebElement>  tiles = driver.findElements(By.className("bg-info"));
		System.out.println(tiles.size());
		
		WebElement manageProducts = driver.findElement(By.xpath("//li[@class='nav-item'][5]"));
		manageProducts.click();
		
		WebElement search = driver.findElement(By.cssSelector("[href = 'javascript:void(0)']"));
		search.click();
		
		WebElement heading = driver.findElement(By.cssSelector(".text-dark"));
		System.out.println(heading.getText());
		
		System.out.println(driver.getCurrentUrl()); 
		System.out.println(driver.getTitle());
		
		WebElement productCode = driver.findElement(By.cssSelector("[placeholder='Product Code']"));
		productCode.sendKeys("456");
		
		WebElement search1 = driver.findElement(By.cssSelector("div.card-body button.btn-danger"));
		search1.click();
		
		WebElement productName = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
		System.out.println(productName.getText().replaceAll("P\\d+","").trim());
		
		
		
		
		
		
	}

}
