package assignment_3;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question_3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("http://selenium.qabible.in/");

		driver.manage().window().maximize();

		WebElement logo = driver.findElement(By.xpath("//img[@src='images/logo.png']"));

		System.out.println("Size : " + logo.getSize());

		Point locationOfLogo = logo.getLocation();
		System.out.println("Location : " + locationOfLogo);

		WebElement inputForm = driver.findElement(By.xpath("//a[@href='simple-form-demo.php']"));
		inputForm.click();

		WebElement radioButton = driver.findElement(By.xpath("//a[@href='radio-button-demo.php']"));
		radioButton.click();

		WebElement femaleRadioButton = driver.findElement(By.id("inlineRadio2"));
		femaleRadioButton.click();

		WebElement showSelectedValueButton = driver.findElement(By.id("button-one"));
		showSelectedValueButton.click();

		WebElement messageText = driver.findElement(By.id("message-one"));
		System.out.println(messageText.getText());

		WebElement patientGenderRadioButton = driver.findElement(By.id("inlineRadio21"));
		patientGenderRadioButton.click();

		WebElement patientAgeRadioButton = driver.findElement(By.id("inlineRadio24"));
		patientAgeRadioButton.click();

		WebElement getResultButton = driver.findElement(By.id("button-two"));
		getResultButton.click();

		WebElement patientDetailsText = driver.findElement(By.id("message-two"));
		System.out.println(patientDetailsText.getText());

		driver.navigate().refresh();

		driver.navigate().to("http://selenium.qabible.in/");

		driver.close();

	}

}
