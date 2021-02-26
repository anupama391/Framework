package Com.Sun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BulkUpload {

	WebDriver driver;
	
	@Test
	public void Test() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://staging.keepfluent.com");
			
		driver.findElement(By.id("mat-input-0")).sendKeys("automationkfa@gmail.com");
		driver.findElement(By.id("mat-input-1")).sendKeys("qwert");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	    String logo = driver.findElement(By.xpath("//div[contains(text(),'KEEPFLUENT')]")).getText();
		Assert.assertEquals(logo, "KEEPFLUENT");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Bulk Upload')]")).click();
		
		
		//driver.findElement(By.xpath("//body/app-root[1]/dew-layout[1]/div[1]/horizontal-navigation[1]/mat-toolbar[1]/div[2]/app-navigation[1]/button[1]/span[1]")).click();
		
		//driver.findElement(By.xpath('/html/body/app-root/dew-layout/div/horizontal-navigation/mat-toolbar/div[2]/app-navigation/button[2]/span[1]')).click();
	                        	
	}
}
