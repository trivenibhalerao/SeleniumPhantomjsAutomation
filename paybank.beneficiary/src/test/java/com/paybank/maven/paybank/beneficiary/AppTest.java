package com.paybank.maven.paybank.beneficiary;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
   
	WebDriver driver;
	String appURL = "https://pay-bank-hello.cfapps.io/#/login";

	@BeforeClass
	public void testSetUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);  
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "Resources\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        driver = new PhantomJSDriver(caps); 
        driver.manage().window().maximize();
	}
	
	@org.testng.annotations.Test(groups ="Pass")
	public void verifyBeneficiaryAdded() throws InterruptedException {
		driver.navigate().to(appURL);
		System.out.println("URL hits");
		driver.findElement(By.id("name")).sendKeys("Username");
		System.out.println("Name entered");
		driver.findElement(By.id("pass")).sendKeys("Pass");
		System.out.println("Password entered");
		driver.findElement(By.className("btn")).click();
		System.out.println("Btn clicked");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a")).click();
		
		System.out.println("Add beneficiary clicked");
		Thread.sleep(1000);
		driver.findElement(By.id("name")).sendKeys("Triveni");
		System.out.println(driver.findElement(By.id("name")).getAttribute("placeholder")); 
		System.out.println("Account name entered");
		Thread.sleep(1000);
		WebElement accNumber=driver.findElement(By.id("acNumber"));
		accNumber.sendKeys("100010103");
		//driver.findElement(By.xpath(".//*[@id='acNumber']")).sendKeys("100010103");	
		
		System.out.println("Number entered");
		Thread.sleep(1000);
		//driver.findElement(By.className("btn")).click();
		
		Thread.sleep(1000);
		List<WebElement> listAccountNumber;
		ArrayList<String> listAccNumString= new ArrayList<String>();

		listAccountNumber=driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println(listAccountNumber.size());
		for(int i=1;i<=listAccountNumber.size();i++)
		{
			String txt=(driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText());
			listAccNumString.add(txt);
			System.out.println(txt);
		}
		System.out.println(listAccNumString);
		if(listAccNumString.contains("100010103"))
		{
			System.out.println("Pass");
			assertTrue(listAccNumString.contains("100010103"));
			//Assert.assertEquals(listAccNumString.get(listAccNumString.size()-1), "100010103", "Assertion Failed");
		}
		else
			System.out.println("Fail");
		}
		
		@org.testng.annotations.Test(groups ="Fail")
		public void verifyBeneficiaryAddedFailed() throws InterruptedException {
			driver.navigate().to(appURL);
			System.out.println("URL hits");
			driver.findElement(By.id("name")).sendKeys("Username");
			System.out.println("Name entered");
			driver.findElement(By.id("pass")).sendKeys("Pass");
			System.out.println("Password entered");
			driver.findElement(By.className("btn")).click();
			System.out.println("Btn clicked");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a")).click();
			
			System.out.println("Add beneficiary clicked");
			Thread.sleep(1000);
			driver.findElement(By.id("name")).sendKeys("Triveni");
			System.out.println(driver.findElement(By.id("name")).getAttribute("placeholder")); 
			System.out.println("Account name entered");
			Thread.sleep(1000);
			WebElement accNumber=driver.findElement(By.id("acNumber"));
			accNumber.sendKeys("100010103");
			//driver.findElement(By.xpath(".//*[@id='acNumber']")).sendKeys("100010103");	
			
			System.out.println("Number entered");
			Thread.sleep(1000);
			//driver.findElement(By.className("btn")).click();
			
			Thread.sleep(1000);
			List<WebElement> listAccountNumber;
			ArrayList<String> listAccNumString= new ArrayList<String>();

			listAccountNumber=driver.findElements(By.xpath("//table/tbody/tr"));
			System.out.println(listAccountNumber.size());
			for(int i=1;i<=listAccountNumber.size();i++)
			{
				String txt=(driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText());
				listAccNumString.add(txt);
				System.out.println(txt);
			}
			System.out.println(listAccNumString);
			
				assertFalse(listAccNumString.contains("100010103"));
				//Assert.assertEquals(listAccNumString, "100010103", "Failed");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
