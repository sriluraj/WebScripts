package com.Web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_02AddUser {
	WebDriver driver;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
    private XSSFCell cell;
	

	@Test
	@Parameters({"URL","Fpath"})
		public void Adduser(String URL,String Fpath) throws InterruptedException, IOException
		{
	//	open the URL
			System.setProperty("webdriver.chrome.driver", "./WebDriver\\\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			
	//Add the user from Excel	
			File file=new File(Fpath);
			FileInputStream fis=new FileInputStream(file);
			workbook=new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			
			//System.out.println("Total rows:"+sheet.getLastRowNum( ));
			for (int i = 1; i <= sheet.getLastRowNum( ); i++) {
				
				for(int j=1;j<=1;j++)
				{
				
					WebElement add=driver.findElement(By.xpath("/html/body/table/thead/tr[2]/td/button"));	
					add.click();
	            cell = sheet.getRow(i).getCell(0);
	            DataFormatter formatter = new DataFormatter();
	            String fname = formatter.formatCellValue(cell);
	            cell = sheet.getRow(i).getCell(1);
	            String lname = formatter.formatCellValue(cell);
	            cell = sheet.getRow(i).getCell(2);
	            String Uname=formatter.formatCellValue(cell);
	            cell = sheet.getRow(i).getCell(3);
	            String psd=formatter.formatCellValue(cell);
	            driver.findElement(By.name("FirstName")).clear();
	            driver.findElement(By.name("FirstName")).sendKeys(fname );
	            driver.findElement(By.name("LastName")).clear();
	            driver.findElement(By.name("LastName")).sendKeys(lname );
	            driver.findElement(By.name("UserName")).clear();
	            driver.findElement(By.name("UserName")).sendKeys(Uname);
	            driver.findElement(By.name("Password")).clear();
	            driver.findElement(By.name("Password")).sendKeys(psd);
	            WebElement radio=driver.findElement(By.name("optionsRadios"));
	   		 boolean radioBtnIsDisplayed = radio.isDisplayed();
	   	      System.out.println("Company AAA button displayed: "+radioBtnIsDisplayed);
	   	     boolean radioBtnIsEnabled = radio.isEnabled();

	   	     System.out.println("Company AAA button enabled: "+radioBtnIsEnabled);
	   		radio.click();
	   		
	   		
	   		Select Role=new Select(driver.findElement(By.name("RoleId")));
	   		//Role.deselectByVisibleText("Sales Team");
	   		Role.selectByIndex(2);
	   		cell = sheet.getRow(i).getCell(6);	
	   	 String mail=formatter.formatCellValue(cell);
	   	cell = sheet.getRow(i).getCell(7);
	   	 String pno=formatter.formatCellValue(cell);
	   	driver.findElement(By.name("Email")).clear();
	   	driver.findElement(By.name("Email")).sendKeys(mail);
	 	driver.findElement(By.name("Mobilephone")).clear();
	   	driver.findElement(By.name("Mobilephone")).sendKeys(pno);
	    driver.manage( ).timeouts( ).implicitlyWait(3, TimeUnit.SECONDS);
				 
	   	
	 driver.findElement(By.xpath("/html/body/div[3]/div[3]/button[2]")).click();
	 Thread.sleep(2000);
				
				
}
									
		}
			
		}

	
}

