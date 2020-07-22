package com.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_01Additem {
	WebDriver driver;
	@Test
	@Parameters({"URL","Fname","Lname","Uname","psd","Email","pno"})
public void additem(String URL,String Fname,String Lname,String Uname,String psd,String Email,String pno)
	{
		System.setProperty("webdriver.chrome.driver", "./WebDriver\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(URL);
		WebElement add=driver.findElement(By.xpath("/html/body/table/thead/tr[2]/td/button"));	
		add.click();
		driver.findElement(By.name("FirstName")).sendKeys(Fname);
		driver.findElement(By.name("LastName")).sendKeys(Lname);
		driver.findElement(By.name("UserName")).sendKeys(Uname);
		driver.findElement(By.name("Password")).sendKeys(psd);
		WebElement radio=driver.findElement(By.name("optionsRadios"));
		 boolean radioBtnIsDisplayed = radio.isDisplayed();
	      System.out.println("Company AAA button displayed: "+radioBtnIsDisplayed);
	     boolean radioBtnIsEnabled = radio.isEnabled();

	     System.out.println("Company AAA button enabled: "+radioBtnIsEnabled);
		radio.click();
		
		Select Role=new Select(driver.findElement(By.name("RoleId")));
		//Role.deselectByVisibleText("Sales Team");
		Role.selectByIndex(1);
		driver.findElement(By.name("Email")).sendKeys(Email);
		driver.findElement(By.name("Mobilephone")).sendKeys(pno);
		
		WebElement save=driver.findElement(By.xpath("/html/body/div[3]/div[3]/button[2]"));
		save.click();
}
	
	
}
