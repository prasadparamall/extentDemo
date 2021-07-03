package Testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import Baseclass.baseclass;
import utilities.ExtentManager;

public class ManagerLoginpage extends baseclass {
 
	
	@Test
	public void setup1() throws InterruptedException {
		
		click("mngloinbtn_XPATH");
		//Thread.sleep(1000);
		
		
	}
 
}

