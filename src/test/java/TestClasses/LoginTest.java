package TestClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageClasses.LoginPage;
import Utilities.BaseClass;
import Utilities.FetchDataFromProperty;

@Listeners(Utilities.ListenerImplementation.class)
public class LoginTest extends BaseClass {
	
	LoginPage obj=new LoginPage();
	
	
	
	@Test(priority=0,groups="sanity")
	public  void executeLoginTest() throws InterruptedException
	{
		test = reports.createTest("Verify Valid Login");
		logger.info("***************TestCase Verify Login starts*****************"); 
		addImplicitWait();
		try {
			driver.findElement(By.xpath(obj.getUserName())).sendKeys(FetchDataFromProperty.readDataFromProperty().getProperty("email"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		test.log(Status.INFO, "Username is entered");
		logger.info("User enters username");
		driver.findElement(By.xpath(obj.getContinueButton())).click();	
		test.log(Status.INFO, "User clicks on Continue button");
		logger.info("User clicks on continue button");
		try {
			driver.findElement(By.xpath(obj.getPassword())).sendKeys(FetchDataFromProperty.readDataFromProperty().getProperty("password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.INFO, "Username is Password");
		logger.info("User enters password");
		driver.findElement(By.xpath(obj.clickOnSubmit())).click();
		test.log(Status.INFO, "Username click on Submit button");
		logger.info("User clicks on Submit button");
		WebElement homeText=driver.findElement(By.xpath(obj.verifyLogin()));
		if(homeText.isDisplayed()) {
			test.log(Status.PASS, "Login Successful");
			logger.info("Login Successful");
		}
		else {
			test.log(Status.FAIL, "Login Unuccessful");
			logger.info("Login unuccessful");
			throw new NullPointerException("Patient Login Failed");
		}
		
	}
	
	/*@AfterTest
	public void closeBrowser() throws InterruptedException {
		teardown();
	}*/
	
	
	
	
	
	
	
	
	
	
	

}
