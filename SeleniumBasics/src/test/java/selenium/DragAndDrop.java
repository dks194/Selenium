package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

		driver.manage().window().maximize();

		WebElement dragElement = driver.findElement(By.id("draggable"));

		WebElement dropElement = driver.findElement(By.id("droppable"));

		Actions actions = new Actions(driver);

		actions.dragAndDrop(dragElement, dropElement).perform();

		driver.navigate().to(" https://demo.guru99.com/test/drag_drop.html");

		// DEBIT SIDE

		WebElement dragDebitAmount = driver.findElement(By.id("fourth"));
		WebElement dropDebitAmount = driver.findElement(By.id("amt7"));
		

		Actions actions1 = new Actions(driver);
		actions1.dragAndDrop(dragDebitAmount, dropDebitAmount).perform();

		WebElement dragDebitAccount = driver.findElement(By.id("credit2"));
		WebElement dropDebitAccount = driver.findElement(By.id("bank"));

		Actions actions2 = new Actions(driver);
		actions2.dragAndDrop(dragDebitAccount, dropDebitAccount).perform();

		// CREDIT SIDE

		WebElement dragCreditAmount = driver.findElement(By.id("fourth"));
		WebElement dropCreditAmount = driver.findElement(By.id("amt8"));

		Actions actions3 = new Actions(driver);
		actions3.dragAndDrop(dragCreditAmount, dropCreditAmount).perform();

		WebElement dragCreditAccount = driver.findElement(By.id("credit1"));
		WebElement dropCreditAccount = driver.findElement(By.id("loan"));

		Actions actions4 = new Actions(driver);
		actions4.dragAndDrop(dragCreditAccount, dropCreditAccount).perform();

		// Mouse Hover and Click

		WebElement perfectButton = driver.findElement(By.xpath("//a[text()='Perfect!']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", perfectButton);

		Actions actionsButton = new Actions(driver);

		actionsButton.moveToElement(perfectButton).click().build().perform();

		driver.close();

	}

}
