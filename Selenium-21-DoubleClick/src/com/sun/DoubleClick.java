package com.sun;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoubleClick
 {
	
	  @Test
	  public void DoubleClickTest1() {
	
     //Launch the Application 
	 
	  System.setProperty("Webdriver.chrome.driver","C:\\work\\chromedriver.exe");
	  
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	 
      driver.get("http://demo.guru99.com/test/simple_context_menu.html");

     //Double click the button to launch an alertbox
       Actions action = new Actions(driver);
        
       WebElement link =driver.findElement(By.xpath("/html[1]/body[1]/button[1]"));
        
       action.doubleClick(link).perform();

        
     //Switch to the alert box and click on OK button
       Alert alert = driver.switchTo().alert();
       System.out.println("Print alert message :" +alert.getText());
       alert.accept();
      
       
     //Closing the driver instance
       driver.close();
}
}
