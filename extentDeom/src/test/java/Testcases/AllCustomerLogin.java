package Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Baseclass.baseclass;
import utilities.XLUtility;

public class AllCustomerLogin extends baseclass {
	
	
@BeforeTest
public void AddCus() throws InterruptedException {
	
	click("custLo_XPATH");
	Thread.sleep(2000);
	
}
	
	@Test(dataProvider = "customerdata")
	public void open1(String customer, String exp) throws InterruptedException {
	
		
	WebElement cust=driver.findElement(By.xpath(or.getProperty("custname_XPATH")));
	//cust.clear();
	cust.click();
	Thread.sleep(2000);
	cust.sendKeys(customer,Keys.ENTER);
	Thread.sleep(1000);
	click("loginbtn_XPATH");
	Thread.sleep(2000);
	
	click("withdb_XPATH");
	type("witha_XPATH","1000");
	Thread.sleep(1000);
	
	WebElement withdrawbutton=driver.findElement(By.xpath(or.getProperty("withb_XPATH")));
	System.out.println(withdrawbutton.getText());
	withdrawbutton.click();
	
	Thread.sleep(1000);
	
	click("depositb_XPATH");
	Thread.sleep(1000);
	type("deposita_XPATH","1000");
	Thread.sleep(1000);
	WebElement depositbutton=driver.findElement(By.xpath(or.getProperty("depositbb_XPATH")));
	depositbutton.click();
	System.out.println(depositbutton.getText());
	Thread.sleep(1000);
	
	
	click("withdb_XPATH");
	Thread.sleep(1000);
	type("witha_XPATH","500");
	Thread.sleep(1000);
	WebElement withdrawbutton1=driver.findElement(By.xpath(or.getProperty("withb_XPATH")));
	withdrawbutton1.click();
	System.out.println(withdrawbutton1.getText());
	Thread.sleep(1000);
	
	click("tranb_XPATH");
	Thread.sleep(1000);
	click("tranbb_XPATH");
	Thread.sleep(1000);
	
	click("logout_XPATH");
	Thread.sleep(2000);
	
	
	
}
	
	@DataProvider(name="customerdata")
	public Object [][] opendata() throws IOException{
	
	String path=".\\datafiles\\custmername.xlsx";
	XLUtility excel=new XLUtility(path);
	
	int rows=excel.getRowCount("sheet1");
	int cols=excel.getCellCount("sheet1", 1);
	
	Object [][] loginData1=new Object[rows][cols];
			
	for(int i=1;i<=rows;i++) {
		for(int j=0;j<cols;j++) {
			
			loginData1[i - 1][j]=excel.getCellData("sheet1", i, j);
		}
		
	}
	
	return loginData1;		
}


}
