package com.Web;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_03ValidateUser {
	
	String URL="http://www.way2automation.com/angularjs-protractor/webtables/";

	@Test
		public void getDetails() throws InterruptedException, IOException
		{
		System.setProperty("webdriver.chrome.driver", "./WebDriver\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	    String	Expecteduser="matt";
		String first_part = "/html/body/table/tbody/tr[";
		 String second_part = "]/td[3]";
		 int rowcount=7;
		 String message="Not valid user";
		
		 for (int i=1; i<=rowcount; i++){
			  
			   String final_xpath = first_part+i+second_part;
			   //Will retrieve value from located cell and print It.
			   String Table_data = driver.findElement(By.xpath(final_xpath)).getText();
			   System.out.print(Table_data +"\n  "); 
			   
			 ArrayList<String> list=new ArrayList<String>();
			   list.add(Table_data);
			   //System.out.println("Listvalues:"+list);
			   if (list.contains(Expecteduser))
			   {
				 System.out.println("User is Present in the table:"+list);  
			   }else
			   {
				   System.out.println("USer not present in the table");
			   }
			  // System.out.println("User Available in the list " + list.contains(Expecteduser));
			  // Assert.assertNotEquals(list,Expecteduser,message);
			  }
			   System.out.println("");
			   
			  
			 } 
			 

		 
		}
	


