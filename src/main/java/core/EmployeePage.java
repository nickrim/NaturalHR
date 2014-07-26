package core;
	
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EmployeePage {

       WebDriver driver;
       String baseUrl = "https://www.naturalhr.com/";
       
       public EmployeePage(WebDriver wd) {
              driver = wd;
       }

   	public void deleteEmployee() {

		driver.get(baseUrl + "/hr/employee/");

		List<WebElement> count = driver.findElements(By.xpath("//img[@alt='Delete']"));
		
		int empCount = count.size();
		
	      for(int i = 0; i < empCount; i++) { 	  
	  		driver.findElement(By.xpath("//img[@alt='Delete']")).click();
	  		driver.switchTo().alert().accept();	  
	       }
   	}
       
       public void logoff() {

    	             driver.findElement(By.cssSelector("b.caret")).click();
   	                 driver.findElement(By.linkText("Logoff")).click();
  	                 driver.quit();
  	                 driver = null;
 	          }
         
       public boolean verifyBodyContains(String text) {

	              return driver.findElement(By.tagName("body")).getText().contains(text);

	       }
}