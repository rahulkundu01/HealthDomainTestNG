package TestClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageClasses.RegisterPage;
import Utilities.BaseClass;
import Utilities.ListenerImplementation;


@Listeners(ListenerImplementation.class)

public class RegisterPatientTest extends BaseClass {
	
	LoginTest obj1=new LoginTest();
	RegisterPage rpObj= new RegisterPage();
	
	
	
	
	@DataProvider(name="MyDp1")
	public Object [][] method()
	{
		return new Object [][] {{"Harry","dsouza","32","Mumbai"},
			
			{"Henry","Williamson","45","Kolkata"}};
		
	}
	
	@Test(dataProvider="MyDp1",groups="sanity")
	public void addPatient(String fn,String ln, String ag,String add) throws InterruptedException, IOException
	{
		test = reports.createTest("Verify Patient Registration");
		logger.info("***************TestCase Verify Register Patient starts*****************"); 
		addImplicitWait();
		logger.info("Call the login method");
		//obj1.executeLoginTest(); logger.info("After Login");
		Thread.sleep(3000);
		driver.findElement(By.xpath(rpObj.addPatientButton())).click();
		logger.info("Clicked on Add patient menu button");
		test.log(Status.INFO, "Clicked on Add patient menu button");
		Thread.sleep(3000);
		driver.findElement(By.xpath(rpObj.patientIdentityButton())).click();
		logger.info("Clicked on Patient identity button");
		test.log(Status.INFO, "Clicked on Patient identity button");
		Thread.sleep(3000);
		driver.findElement(By.xpath(rpObj.firstName())).sendKeys(fn);
		logger.info("Entered First name");
		test.log(Status.INFO, "Entered First name");
		Thread.sleep(3000);
		driver.findElement(By.xpath(rpObj.lastName())).sendKeys(ln);
		logger.info("Entered Last name");
		test.log(Status.INFO, "Entered Last name");
		Thread.sleep(3000);
		scrollDown();
		driver.findElement(By.xpath(rpObj.gender())).click();
		logger.info("Select Gender radio button");
		test.log(Status.INFO, "Select Gender radio button");
		Thread.sleep(3000);
		driver.findElement(By.xpath(rpObj.dobStataus())).click();
		logger.info("Entered Date of Birth");
		test.log(Status.INFO, "Entered Date of Birth");
		Thread.sleep(3000);
		driver.findElement(By.xpath(rpObj.age())).sendKeys(ag);
		logger.info("Entered Age");
		test.log(Status.INFO, "Entered Age");
		Thread.sleep(3000);
		scrollDown();
		driver.findElement(By.xpath(rpObj.address())).sendKeys(add);
		logger.info("Entered Address");
		test.log(Status.INFO, "Entered Address");
		Thread.sleep(3000);
		driver.findElement(By.xpath(rpObj.btnregPat())).click();
		logger.info("Clicked on register button");
		test.log(Status.INFO, "Clicked on register button");
		Thread.sleep(3000);
		WebElement patId=driver.findElement(By.xpath(rpObj.validatePatID()));
		
		if(patId.isDisplayed()==true)
		{
			System.out.println("Test Case Passed");
			//captureScreenShot(driver);
			test.log(Status.PASS, "Test Case Passed: Registration Successful");
			logger.info("Test Case Passed: Registration Successful");
		}
		else
		{
			test.log(Status.FAIL, "Test Case Failed: Registration Unsuccessful");
			logger.info("Test Case Failed: Registration Unsuccessful");
			throw new NullPointerException("Patient Registration Failed");
			
		}
		
		
		
		driver.findElement(By.xpath(rpObj.closePg())).click();
		
		
		
		
		
	}
	
	
	
	

}
