package core;
	
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EmployeeQuickAddPage {

       WebDriver driver;
       String baseUrl = "https://www.naturalhr.com/";
       
       public EmployeeQuickAddPage(WebDriver wd) {
              driver = wd;
       }

       public void quickAddEmp() throws InterruptedException {

   		driver.get(baseUrl + "/hr/employee/employee-quick-add");

   		driver.findElement(By.cssSelector("option[value=\"Current\"]")).click();
   		driver.findElement(By.name("works_id")).clear();
   		driver.findElement(By.name("works_id")).sendKeys("123456");
   		driver.findElement(By.name("sur_name")).clear();
   		driver.findElement(By.name("sur_name")).sendKeys("Moore");
   		driver.findElement(By.name("first_name")).clear();
   		driver.findElement(By.name("first_name")).sendKeys("Alex");
   		driver.findElement(By.xpath("//form/div/div[5]/div/select/option[2]")).click();
   		
   		String ssn = Integer.toString(new Random().nextInt(899999999) + 100000000);
   		
   		driver.findElement(By.name("national_insurance")).clear();
   		driver.findElement(By.name("national_insurance")).sendKeys(ssn);

   		driver.findElement(By.name("dob")).sendKeys("01/01/1970");

   		driver.findElement(By.name("start_date")).sendKeys("01/01/2014");

   		if ((driver.findElements(By.xpath("//form/div/div[9]/div/select/option")).size()) > 1) {
   			new Select(driver.findElement(By.name("job_title")))
   			.selectByVisibleText("Software Engineer");
   		} else {
   			 driver.findElement(By.id("mws-form-dialog-title-btn")).click();
   			 driver.findElement(By.id("title_name")).clear();
   			 driver.findElement(By.id("title_name")).sendKeys("Software Engineer");
   			 driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
   			 driver.findElement(By.cssSelector("input.refresh16")).click();
   			 Thread.sleep(1000);
   			 new Select(driver.findElement(By.name("job_title")))
   			 .selectByVisibleText("Software Engineer");
   		}
   		
   		if ((driver.findElements(By.xpath("//form/div/div[10]/div/select/option")).size()) > 1) {
   			new Select(driver.findElement(By.name("job_status")))
   			.selectByVisibleText("Active");			
   		} else {
   			 driver.findElement(By.id("mws-form-dialog-status-btn")).click();
   			 driver.findElement(By.id("status_name")).clear();
   			 driver.findElement(By.id("status_name")).sendKeys("Active");
   			 driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
   			 driver.findElement(By.cssSelector("a.refresh-status > input.refresh16")).click();
   			 Thread.sleep(1000);
   			 new Select(driver.findElement(By.name("job_status")))
   			 .selectByVisibleText("Active");	
   		}
   		
   		if ((driver.findElements(By.xpath("//form/div/div[11]/div/select/option")).size()) > 1) {
   			new Select(driver.findElement(By.name("department")))
   			.selectByVisibleText("QA");
   		} else {
   			driver.findElement(By.id("mws-form-dialog-dept-btn")).click();
   			driver.findElement(By.id("dept_name")).clear();
   			driver.findElement(By.id("dept_name")).sendKeys("QA");
   			driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
   			driver.findElement(By.cssSelector("a.refresh-dept > input.refresh16")).click();
   			Thread.sleep(1000);
   			new Select(driver.findElement(By.name("department")))
   			.selectByVisibleText("QA");
   		}

   		driver.findElement(By.name("holidays_per_year")).sendKeys("10");
   		driver.findElement(By.xpath("//form/div/div[16]/div/select/option[2]")).click();
   		
   		driver.findElement(By.name("submit")).click();
   	//	assertTrue("Failure", (driver.findElement(By.tagName("body")).getText()
   	//	.contains("Employee successfully added")));
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