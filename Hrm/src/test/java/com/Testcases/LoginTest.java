package com.Testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Testcases.BaseClass.BaseTests;


public class LoginTest extends BaseTests{
	LoginPage objLogin = new LoginPage(null);
	    //public static LoginPage objLogin;
	    @Test(priority = 1)
	    public void HomeTest() {
	    	
	          // login to application
	    	FileInputStream fis;
			try {
				fis = new FileInputStream("D:\\Users1\\Station.xlsx");
			 
	    	XSSFWorkbook wk = new XSSFWorkbook(fis);
	    	XSSFSheet sheet = wk.getSheet("LoginData");
	    	
	    	int rowcount = sheet.getLastRowNum();
	    	sheet.getRow(1).getLastCellNum();
	    	
	    	for(int i=1;i<=rowcount;i++)
	    	{
	    		XSSFRow celldata = sheet.getRow(i);
	    	  String user = celldata.getCell(0).getStringCellValue();
	    		String pass = celldata.getCell(1).getStringCellValue();
	    		System.out.println(user+pass);
	    		
	          objLogin.login(user, pass);
	 
	      String expectedError = objLogin.getErrorMessage();
	 
	          // Verify home page
	          Assert.assertTrue(expectedError.contains("Username cannot be empty"));
	    	
	          
	    	}
			}
	    	catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
