package com.sun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextClick {
	@Test
	public void RightClickTest() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com//test//simple_context_menu.html");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		
		WebElement link = driver.findElement(By.cssSelector(".context-menu-one"));
		
		action.contextClick(link).perform();
		
		WebElement element = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
		element.click();
		
		System.out.println("Print alert message :"+ driver.switchTo().alert().getText() );
		
		//Accept the alert message
		driver.switchTo().alert().accept();
		
		//close the instance
		driver.close();
	}

}
