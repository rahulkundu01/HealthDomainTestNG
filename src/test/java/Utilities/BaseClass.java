package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ConstantData.constantData;

public class BaseClass {
	
	
	
	
	public static WebDriver driver;
	public static Logger logger;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static ExtentSparkReporter htmlReporter;
	
	
	@BeforeSuite(alwaysRun = true)
	public void openBrowser() throws IOException
	{
		String browserName=FetchDataFromProperty.readDataFromProperty().getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			driver.get(FetchDataFromProperty.readDataFromProperty().getProperty("URL"));
			driver.manage().window().maximize();
			//for logging
			logger = (Logger) LogManager.getLogger("Health Cart");
			logger.info("url opened");
		}
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			driver.get(FetchDataFromProperty.readDataFromProperty().getProperty("URL"));
			driver.manage().window().maximize();
		}
		
		if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			driver.get(FetchDataFromProperty.readDataFromProperty().getProperty("URL"));
			driver.manage().window().maximize();
		}
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String reportPath =  "test-output/SparkReport/SparkReport_" + timestamp + ".html";
		 	htmlReporter = new ExtentSparkReporter(reportPath);
	        reports = new ExtentReports();
	        reports.attachReporter(htmlReporter);
	        
	        
	        reports.setSystemInfo("Machine", "RKTest1");
	        reports.setSystemInfo("OS", "Windows11");
	        reports.setSystemInfo("User", "Rahul Kundu");
	        reports.setSystemInfo("Browser", "Chrome");

	        htmlReporter.config().setDocumentTitle("Automation Test Report");
	        htmlReporter.config().setReportName("Regression Suite for Open MRS");
	        htmlReporter.config().setTheme(Theme.STANDARD);
		
	}
	
	@AfterMethod
    public void captureStatus(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED", ExtentColor.RED));
            test.log(Status.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED", ExtentColor.GREEN));
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED", ExtentColor.ORANGE));
        }
    }
	
	
	
	public static void addImplicitWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	
	/*	public static void takeScreenShot(WebDriver driver) throws IOException
		{
			if (driver != null) {

				TakesScreenshot srcshot=(TakesScreenshot)driver;
				File srcfile=srcshot.getScreenshotAs(OutputType.FILE);
				File DestFile=new File(constantData.ScreenShotPath);
				FileUtils.copyFile(srcfile, DestFile);
			    // ...save file
			} else {
			    System.out.println("Driver is null! Cannot take screenshot.");
			}
			
		}*/
	
	//user method to capture screen shot
	/*	public static void captureScreenShot(WebDriver driver) throws IOException
		{
			//step1: convert webdriver object to TakesScreenshot interface
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			//step2: call getScreenshotAs method to create image file
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		
			//step3: copy image file to destination
			FileUtils.copyFile(src, dest);
			
			try {
	            String fileName = String.format("Screenshot-%s.jpg", Calendar
	                    .getInstance().getTimeInMillis());
	            
	            TakesScreenshot ts = (TakesScreenshot)driver;
	            File source = ts.getScreenshotAs(OutputType.FILE);
	            String dest="./screenshot/"+ fileName;
	            File snapshotDest =new File(dest);
	            FileUtils.copyFile(source, snapshotDest);
	            //Reporter.log("Screen Shots file :  " + dest);
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to take screenshot !", e);
	        }
		}*/
		
		
		@AfterSuite (alwaysRun = true)
		public void teardown() throws InterruptedException {
			Thread.sleep(4000);
			driver.close();
			driver.quit();
			reports.flush();
			
		}
		
		
		
		
	
	
	
	
	

}
