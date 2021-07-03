package Baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utilities.ExtentManager;



public class baseclass {
	
	    public static WebDriver driver;
	    public static WebElement driver1;
		public static Properties pro;
		public static Properties or;
		public static FileInputStream fis;
		public static String browser;
	 
	
	@BeforeSuite
	 public void BeforeSuite() {
	  ExtentManager.setExtent();
	 }
	 
	 @AfterSuite
	 public void AfterSuite() {
	  ExtentManager.endReport();
	 }
	 
	 @BeforeMethod
	 public void setup() {
					
		 if (driver == null) {
					try {
						fis= new FileInputStream("C:\\Users\\BOSU\\eclipse-workspace\\extentDeom\\configurations\\config.properties");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pro=new Properties();
					try {
						pro.load(fis);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//log.debug("pro file loaded  ...");
					String ss=pro.getProperty("browser");
					System.out.println(ss);
					
					try {
						fis= new FileInputStream("C:\\Users\\BOSU\\eclipse-workspace\\extentDeom\\configurations\\OR.properties");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					or=new Properties();
					try {
						or.load(fis);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				//	log.debug("or file loaded  ...");
					String ss1=or.getProperty("mngloinbtn");
					System.out.println(ss);
			
				if(pro.getProperty("browser").equals("chrome")) {
					
					System.setProperty("webdriver.chrome.driver","C:\\Users\\BOSU\\eclipse-workspace\\extentDeom\\Drivers\\chromedriver.exe");
					driver = new ChromeDriver();
					//log.debug("chrome Launched  ...");
				}else if(pro.getProperty("browser").equals("firefox")) {
					
					System.setProperty("webdriver.gecko.driver","C:\\Users\\BOSU\\eclipse-workspace\\extentDeom\\Drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
					//log.debug("chrome Launched  ...");
				}else if(pro.getProperty("browser").equals("ie")) {
					
					System.setProperty("webdriver.ie.driver","C:\\Users\\BOSU\\eclipse-workspace\\extentDeom\\Drivers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					//log.debug("chrome Launched  ...");
			}
			    
				driver.manage().window().maximize();
				driver.get(pro.getProperty("url"));
				//log.debug("Open Url  ...");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//Thread.sleep(1000);
		 
	 }
	 
	 }
	 
	 public static String screenShot(WebDriver driver,String filename) {
	  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	  TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	  File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
	  String destination = System.getProperty("user.dir")+"\\ScreenShot\\"+filename+"_"+dateName+".png";
	  File finalDestination= new File(destination);
	  try {
	   FileUtils.copyFile(source, finalDestination);
	  } catch (Exception e) {
	   // TODO Auto-generated catch block
	   e.getMessage();
	  }
	  return destination;
	 }
	 
	 public static String getCurrentTime() {  
	     String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());  
	     return currentDate;  
	 }  

	 public void click(String locator) {

			if (locator.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(or.getProperty(locator))).click();
			} else if (locator.endsWith("_XPATH")) {
				driver.findElement(By.xpath(or.getProperty(locator))).click();
			} else if (locator.endsWith("_ID")) {
				driver.findElement(By.id(or.getProperty(locator))).click();
			}
			//CustomListeners.testReport.get().log(Status.INFO, "Clicking on : " + locator);
		}

		public void type(String locator, String value) {

			if (locator.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);
			} else if (locator.endsWith("_XPATH")) {
				driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
			} else if (locator.endsWith("_ID")) {
				driver.findElement(By.id(or.getProperty(locator))).sendKeys(value);
			}

			//CustomListeners.testReport.get().log(Status.INFO, "Typing in : " + locator + " entered value as " + value);

		}
		
		@AfterSuite
		 public void tearDown() throws IOException {
			 if(driver!= null) {
					driver.quit();
					}
		 } 
}
