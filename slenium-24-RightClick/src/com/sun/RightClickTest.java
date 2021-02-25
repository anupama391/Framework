package com.sun;

import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RightClickTest {
	
	WebDriver driver;
	String URL = "http://medialize.github.io//jQuery-contextMenu/demo.html";
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	//This is new commit from Anupama
	@Test
	public void rightClicktest() {
		driver.navigate().to(URL);
		By locator = By.cssSelector(".context-menu-one");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		rightClick(element);
		WebElement ElementEdit = driver.findElement(By.cssSelector(".context-menu-icon-edit"));
		ElementEdit.click();
		Alert alert = driver.switchTo().alert();
		String textEdit=alert.getText();
		System.out.println(textEdit);
		Assert.assertEquals(textEdit, "clicked: edit", "Failed to click on Edit link");
	}
	public void rightClick(WebElement element) {
	 try {
		Actions action = new Actions(driver).contextClick(element);
		action.build().perform();
			
		System.out.println("Sucessfully Right clicked on the element");
		} catch (StaleElementReferenceException e){
			System.out.println("Element is not attched to the page document" + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + element + "was not found in DOM"  + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element" + element + "was not clickable" + e.getStackTrace());
		}
		}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
