package Testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Baseclass.baseclass;
import utilities.XLUtility;


public class ManagerAddcustomer extends baseclass {
	
	
@Test
public void AddCus() throws InterruptedException {
	
	click("Addcus_XPATH");
	//Thread.sleep(2000);
	
}
	
	@Test(dataProvider = "LoginData")
	public void excelR(String fname,String lname,String postcode) throws InterruptedException {
		
		try {
		
		type("fname_XPATH",fname);
		
		type("lname_XPATH",lname);
		
		type("postcode_XPATH",postcode);
		
		click("addbtn_XPATH");

		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	public String [][] getdata() throws IOException{
		
		String path="C:\\Users\\BOSU\\eclipse-workspace\\extentDeom\\datafiles\\loginData.xlsx";
		XLUtility excel=new XLUtility(path);
		
		int rows=excel.getRowCount("sheet1");
		int cols=excel.getCellCount("sheet1", 1);
		
		String [][] loginData=new String[rows][cols];
				
		for(int i=1;i<=rows;i++) {
			for(int j=0;j<cols;j++) {
				
				loginData[i - 1][j]=excel.getCellData("sheet1", i, j);
			}
			
		}
		
		return loginData;		
	}

}
