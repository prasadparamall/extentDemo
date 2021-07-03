package Testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Baseclass.baseclass;

public class gotohomepage extends baseclass {
	
	
	@Test
	public void setup2() throws InterruptedException {
		
		click("home_CSS");
		Thread.sleep(2000);
		
	}
	
	

}
