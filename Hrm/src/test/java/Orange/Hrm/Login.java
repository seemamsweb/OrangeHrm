package Orange.Hrm;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Open Browser
		WebDriver driver = new ChromeDriver();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Open URL
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//Maximize Window
		driver.manage().window().maximize();
		// Extract data from excel
		FileInputStream fis = new FileInputStream("D:\\Users1\\Station.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook wk = new XSSFWorkbook(fis);
		XSSFSheet sheet = wk.getSheet("LoginData");
		
		int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);
		sheet.getRow(1).getLastCellNum();
		for(int i=1;i<=rowcount;i++)
		{
			XSSFRow celldata = sheet.getRow(i);
			String user = celldata.getCell(0).getStringCellValue();
			String pass = celldata.getCell(0).getStringCellValue();
			//find Username textbox
			WebElement UsernameTextBox = driver.findElement(By.name("username"));
			
			//enter value
			UsernameTextBox.clear();
			Thread.sleep(3000);
			UsernameTextBox.sendKeys(user);
			
			
			//find Password textbox
			WebElement PasswordTextBox = driver.findElement(By.name("password"));
			//enter password
			PasswordTextBox.clear();
			Thread.sleep(3000);
			PasswordTextBox.sendKeys(pass);
			
			//find login button
			WebElement LoginButton = driver.findElement(By.xpath("//button[@type='submit']"));
			//Click the button
			LoginButton.click();
			
		}
		
		
		driver.close();
		

	}

}
