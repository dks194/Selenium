package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_Drag {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));

		Actions actions = new Actions(driver);
		actions.dragAndDrop(drag, drop).perform();
		
		driver.navigate().to("https://demo.guru99.com/test/drag_drop.html");

		WebElement DdragAmt = driver.findElement(By.id("fourth"));
		WebElement DdropAmt = driver.findElement(By.id("amt7"));
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView();", DdropAmt);
//		// WebElement DdropAmt = driver.findElement(By.id("amt7"));

		Actions actionsDAmt = new Actions(driver);
		actionsDAmt.dragAndDrop(DdragAmt, DdropAmt).perform();

		WebElement DdragAcc = driver.findElement(By.id("credit2"));
		WebElement DdropAcc = driver.findElement(By.id("bank"));

		Actions actionsDAcc = new Actions(driver);
		actionsDAcc.dragAndDrop(DdragAcc, DdropAcc).perform();

		WebElement CdragAmt = driver.findElement(By.id("fourth"));
		WebElement CdropAmt = driver.findElement(By.id("amt8"));

		Actions actionsCAmt = new Actions(driver);
		actionsCAmt.dragAndDrop(CdragAmt, CdropAmt).perform();

		WebElement CdragAcc = driver.findElement(By.id("credit1"));
		WebElement CdropAcc = driver.findElement(By.id("loan"));

		Actions actionsCAcc = new Actions(driver);
		actionsCAcc.dragAndDrop(CdragAcc, CdropAcc).perform();

		WebElement btn = driver.findElement(By.id("equal"));
		
		Actions perfectBtn = new Actions(driver);
		perfectBtn.moveToElement(btn).click().build().perform();
		
		driver.close();

	}

}
