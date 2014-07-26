//BEGIN

package core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import java.util.Random;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HRTest {

	LoginPage lp = new LoginPage (driver);
	EmployeeQuickAddPage ea = new EmployeeQuickAddPage (driver);
	EmployeePage ep = new EmployeePage (driver);
	static WebDriver driver = new FirefoxDriver();
	static String baseUrl = "https://www.naturalhr.com";
	String email = "anisim@gmail.com";
	String password = "zxcvbn00";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize(); 
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	   }

    @Before
	
    public void setUp() throws Exception {
    	lp.login(email, password);
    	}

	@After
	public void tearDown() throws Exception {
		ea.logoff();
		}

	@Ignore
	@Test
	public void test_01_login() {
			assertEquals("Login was unsuccessful", true, lp.verifyBodyContains("Quickstart"));
		}

	@Ignore	
	@Test
	public void test_02_add_Employee() throws InterruptedException {
		ea.quickAddEmp();
		}
//	@Ignore	
	@Test
	public void test_03_deleteEmployee() {
		ep.deleteEmployee();
		      		assertTrue("Failure", (driver.findElement(By.tagName("body")).getText()
	      		.contains("No employees found")));
	}
	
}