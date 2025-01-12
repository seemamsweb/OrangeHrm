package com.Testcases;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends BaseClass {
	
   WebDriver driver;
 
    @FindBy(name = "username")
    WebElement userName;
 
    @FindBy(name = "password")
    WebElement passWord;
 
    @FindBy(xpath = "//button[@type='submit']")
    WebElement login;
    
    @FindBy(id="spanMessage")
    WebElement errorMessage;
    
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;

        // This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
  }
    
    
 // Set user name in textbox
    public void setUserName(String strUserName) {
          userName.sendKeys(strUserName);
    }
 
    // Set password in password textbox
    public void setPassword(String strPassword) {
    	passWord.sendKeys(strPassword);
    }
 
    // Click on login button
    public void clickLogin() {
          login.click();
    }
    
    public String getErrorMessage() {
        return errorMessage.getText();
  }
    
    public void login(String strUserName, String strPasword) {
    	 
        // Fill user name
        this.setUserName(strUserName);

        // Fill password
        this.setPassword(strPasword);

        // Click Login button
        this.clickLogin();
  }
    //public void clickLogin() throws IOException, InterruptedException {
    


}
