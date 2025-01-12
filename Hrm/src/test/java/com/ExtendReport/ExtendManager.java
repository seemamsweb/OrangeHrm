package com.ExtendReport;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;

import com.Testcases.BaseClass.BaseTests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.openqa.selenium.OutputType;
 

public class ExtendManager extends BaseTests{
 
    private static ExtentReports extent;
    public static String screenshotName;
         
    public static ExtentReports createInstance(String fileName) {
    	ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
                    
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle(fileName);
        spark.config().setEncoding("utf-8");
        spark.config().setReportName(fileName);
         
        extent = new ExtentReports();
        extent.attachReporter(spark);
        
        return extent;
    }
 
     
    public static void captureScreenshot() {
	
    	TakesScreenshot screenshot = (TakesScreenshot)driver;
        
        // Call method to capture screenshot
        File src = screenshot.getScreenshotAs(OutputType.FILE);
 
        try
        {
            Date d = new Date();
            screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";  
            FileUtils.copyFile(src,new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
            System.out.println("Successfully captured a screenshot");
       } catch (IOException e) {
           System.out.println("Exception while taking screenshot " + e.getMessage());
      }
    }

}
