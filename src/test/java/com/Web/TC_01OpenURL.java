package com.Web;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TC_01OpenURL
{
WebDriver driver;
String URL="http://www.way2automation.com/angularjs-protractor/webtables/";

@Test
	public void openURL() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./WebDriver\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		//driver.close();
	
	
		try{
		Thread.sleep(2000);
	
		WebElement add=driver.findElement(By.xpath("/html/body/table/thead/tr[2]/td/button"));	
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", add);
		
	///html/body/table/thead/tr[2]/td/button
	add.click();
		
		
	WebElement Fname=driver.findElement(By.name("FirstName"));
	Fname.sendKeys("Srilatha");
	
	WebElement Lname=driver.findElement(By.name("LastName"));
	Lname.sendKeys("Barija");
	
	WebElement Uname=driver.findElement(By.name("UserName"));
	Uname.sendKeys("sriluraj");
	
	WebElement password=driver.findElement(By.name("Password"));
	password.sendKeys("Temp1234");
	
	WebElement radio=driver.findElement(By.name("optionsRadios"));
	 boolean radioBtnIsDisplayed = radio.isDisplayed();
      System.out.println("Company AAA button displayed: "+radioBtnIsDisplayed);
     boolean radioBtnIsEnabled = radio.isEnabled();

     System.out.println("Company AAA button enabled: "+radioBtnIsEnabled);
	radio.click();
	
	Select Role=new Select(driver.findElement(By.name("RoleId")));
	//Role.deselectByVisibleText("Sales Team");
	Role.selectByIndex(1);
	WebElement email=driver.findElement(By.name("Email"));
	email.sendKeys("sriluraj@gmail.com");
	WebElement mobile=driver.findElement(By.name("Mobilephone"));
	mobile.sendKeys("sriluraj@gmail.com");
	WebElement save=driver.findElement(By.xpath("/html/body/div[3]/div[3]/button[2]"));
	save.click();
		}
		catch(NullPointerException e) 
        { 
            System.out.print("NullPointerException Caught"); 
        }
	
	}
	
	
	}



	


