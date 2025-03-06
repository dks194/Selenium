package testNgPrograms;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AssertionEg {
	WebDriver driver;

	@Test(priority = 1)
	public void verifyTheExactPageISOpensWhileHittingTheURL() {

		Assert.assertEquals(driver.getCurrentUrl(), "https://selenium.qabible.in/");
		System.out.println("URL of the page : " + driver.getCurrentUrl());

	}

	@Test(priority = 2)
	public void verifyTheLogoIsDisplayedOrNotInHomepage() {

		WebElement logo = driver.findElement(By.xpath("(//img[@src='images/logo.png'])[1]"));
		Assert.assertTrue(logo.isDisplayed());
		System.out.println("Logo is displayed : " + logo.isDisplayed());

	}

	@Test(priority = 3)
	public void verifyTheCountOfTabsPresentOnTheHomePage() {

		List<WebElement> allTabs = driver.findElements(By.className("nav-item"));
		// int actualResult = allTabs.size();
		// int expectedresult = 9;
		// Assert.assertEquals(actualResult, expectedresult, "Count Mismatch");// count
		// mismatch message only displays when
		Assert.assertEquals(allTabs.size(), 8); // execution fails,print with the failed

	}

	@Test(priority = 4)
	public void verifyAllTabsArePresentOnTheHomePage() {

		List<WebElement> allTabs = driver.findElements(By.className("nav-item"));
		for (WebElement tab : allTabs) {
			System.out.println(tab.getText() + " " + tab.isDisplayed());
			Assert.assertTrue(tab.isDisplayed());
		}

	}

	@Test(priority = 5)
	public void verifyThatTheMessageTextBoxIsEmptyOnInputFormPage_ByDefault() {
		WebElement inputFormTab = driver.findElement(By.xpath("//a[@href='simple-form-demo.php']"));
		inputFormTab.click();
		WebElement messageTextBox = driver.findElement(By.id("single-input-field"));

		String actual_Value = messageTextBox.getAttribute("value");
		// Assert.assertNull(actual_Value);->expected null but found empty exception
		Assert.assertTrue(actual_Value.isEmpty() || actual_Value == null);
	}

	@Test(priority = 6)
	public void verifyThatTheMessageTextBoxIsEmptyAfterEnteringTheMessage() {

		WebElement inputFormTab = driver.findElement(By.xpath("//a[@href='simple-form-demo.php']"));
		inputFormTab.click();

		WebElement messageTextBox = driver.findElement(By.id("single-input-field"));
		messageTextBox.sendKeys("sample message");

		// Assertion to verify the textbox is not empty after entering message
		String actual_Value = messageTextBox.getAttribute("value");
		Assert.assertFalse(actual_Value.isEmpty());

		// String expected_Value ="sample message";-can provide directly in assert
		// Assert.assetNotNull(actual_Value);
		// Assert.assertEquals(actual_Value, "sample message");
		// Assert.assertFalse(actual_Value.isEmpty());
	}

	@Test(priority = 7)
	public void verifyTheCountOfCheckboxesInCheckboxDemoPage() {

		WebElement inputFormTab = driver.findElement(By.xpath("//a[@href='simple-form-demo.php']"));
		inputFormTab.click();

		WebElement checkboxDemo = driver.findElement(By.cssSelector("[href='check-box-demo.php']"));
		checkboxDemo.click();

		List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
		Assert.assertEquals(allCheckboxes.size(), 5);
		System.out.println("Count of checkboxes : " + allCheckboxes.size());

	}

	@Test(priority = 8)
	public void verifyAllCheckboxesAreUncheckedByDefault() {
		WebElement inputFormTab = driver.findElement(By.xpath("//a[@href='simple-form-demo.php']"));
		inputFormTab.click();

		WebElement checkboxDemo = driver.findElement(By.cssSelector("[href='check-box-demo.php']"));
		checkboxDemo.click();

		int count = 0;
		List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
		for (WebElement checkbox : allCheckboxes) {
			Assert.assertFalse(checkbox.isSelected());
			count++;
			System.out.println("Checkbox " + count + " is selected : " + checkbox.isSelected());
		}
	}

	@Test(priority = 9)
	public void verifyTheCheckbox_CheckBoxOne_IsCheckedOrNotAfterClickingOnIt() {

		WebElement inputFormTab = driver.findElement(By.xpath("//a[@href='simple-form-demo.php']"));
		inputFormTab.click();

		WebElement checkboxDemo = driver.findElement(By.cssSelector("[href='check-box-demo.php']"));
		checkboxDemo.click();

		WebElement checkboxOne = driver.findElement(By.id("check-box-one"));
		checkboxOne.click();

		Assert.assertTrue(checkboxOne.isSelected());
		System.out.println("The checkbox is selected : " + checkboxOne.isSelected());
	}

	@Test(priority = 10)
	public void verifyTheCountOfRadioButtonsIn_RadioButtonsDemo_page() {

		WebElement inputFormTab = driver.findElement(By.xpath("//a[@href='simple-form-demo.php']"));
		inputFormTab.click();

		WebElement radioButtonsDemo = driver.findElement(By.cssSelector("[href='radio-button-demo.php']"));
		radioButtonsDemo.click();

		List<WebElement> allRadioButtons = driver.findElements(By.cssSelector("[type='radio']"));
		Assert.assertEquals(allRadioButtons.size(), 7);

		System.out.println("Count of radio buttons : " + allRadioButtons.size());
	}

	@Test(priority = 11)
	public void verifyAllRadioButtonsAreSelectedOrNotByDefault() {

		WebElement inputFormTab = driver.findElement(By.xpath("//a[@href='simple-form-demo.php']"));
		inputFormTab.click();

		WebElement radioButtonsDemo = driver.findElement(By.cssSelector("[href='radio-button-demo.php']"));
		radioButtonsDemo.click();

		int count = 1;
		List<WebElement> allRadioButtons = driver.findElements(By.cssSelector("[type='radio']"));
		for (WebElement radioButton : allRadioButtons) {
			Assert.assertFalse(radioButton.isSelected());
			System.out.println("Radio button " + count + " is selected : " + radioButton.isSelected());
			count++;
		}
	}

	@Test(priority = 12)
	public void verifyTheRadioButton_Female_IsSelectedOrNotWhileClickingOnIt() {

		WebElement inputFormTab = driver.findElement(By.xpath("//a[@href='simple-form-demo.php']"));
		inputFormTab.click();

		WebElement radioButtonsDemo = driver.findElement(By.cssSelector("[href='radio-button-demo.php']"));
		radioButtonsDemo.click();

		WebElement femaleRadioButton = driver.findElement(By.id("inlineRadio2"));
		femaleRadioButton.click();

		Assert.assertTrue(femaleRadioButton.isSelected());
		System.out.println("Female radio button is selected: " + femaleRadioButton.isSelected());
	}

	@Test(priority = 13)
	public void verifyToSelectOptionRedFromThe_SelectColor_DropdownInSelectInputPage() {

		WebElement inputFormTab = driver.findElement(By.xpath("//a[@href='simple-form-demo.php']"));
		inputFormTab.click();

		WebElement selectInput = driver.findElement(By.cssSelector("[href='select-input.php']"));
		selectInput.click();

		WebElement multiSelectDropdown = driver.findElement(By.id("multi-select-field"));
		Select selectRed = new Select(multiSelectDropdown);
		selectRed.selectByIndex(0);

		WebElement selected = selectRed.getFirstSelectedOption();
		String actualText = selected.getText();
		Assert.assertEquals(actualText, "Red");
		System.out.println("The selected colour is : " + actualText);

	}

	@Test(priority = 14)
	public void verifyTheSecondSelectColorDropdownIs_MultiSelect_Or_Not() {

		WebElement inputFormTab = driver.findElement(By.xpath("//a[@href='simple-form-demo.php']"));
		inputFormTab.click();

		WebElement selectInput = driver.findElement(By.cssSelector("[href='select-input.php']"));
		selectInput.click();

		WebElement multiSelectDropdown = driver.findElement(By.id("multi-select-field"));
		Select select = new Select(multiSelectDropdown);
		Assert.assertTrue(select.isMultiple());
		System.out.println("Dropdown is multi select: " + select.isMultiple());
	}

	@Test(priority = 15)
	public void verifyToSelect_RedGreen_FromSecondSelectColorDropdown() {

		WebElement inputFormTab = driver.findElement(By.xpath("//a[@href='simple-form-demo.php']"));
		inputFormTab.click();

		WebElement selectInput = driver.findElement(By.cssSelector("[href='select-input.php']"));
		selectInput.click();

		WebElement multiSelectDropdown = driver.findElement(By.id("multi-select-field"));
		Select selectOptions = new Select(multiSelectDropdown);
		selectOptions.selectByIndex(0);
		selectOptions.selectByIndex(2);

		List<WebElement> selectedValues = selectOptions.getAllSelectedOptions();
		boolean redSelected = false;
		boolean greenSelected = false;

		for (WebElement option : selectedValues) {

			String optionSelected = option.getText();
			if (optionSelected.equals("Red")) {
				redSelected = true;
			}
			if (optionSelected.equals("Green")) {
				greenSelected = true;
			}
		}

		Assert.assertTrue(redSelected);
		Assert.assertTrue(greenSelected);
		System.out.println("Red selected: " + redSelected);
		System.out.println("Green selected: " + greenSelected);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
