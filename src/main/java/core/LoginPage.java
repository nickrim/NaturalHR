package core;
	
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

       WebDriver driver;
       String baseUrl = "https://www.naturalhr.com";
       
       public LoginPage(WebDriver wd) {
              driver = wd;
       }

       public void login (String email, String password){
       
              driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
              driver.manage().window().maximize();
              driver.get(baseUrl + "/login");
              driver.findElement(By.name("ipt-login")).sendKeys(email);
              driver.findElement(By.name("ipt-password")).sendKeys(password);
              driver.findElement(By.name("submit")).click();
              
       }
      
       public boolean verifyBodyContains(String text) {

	              return driver.findElement(By.tagName("body")).getText().contains(text);

	       }
}