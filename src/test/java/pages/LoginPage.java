package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	 WebDriver driver;

	    By usernameField = By.name("username");
	    By passwordField = By.name("password");
	    By loginBtn = By.xpath("//button[@type='submit']");
	    By errorMsg = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void enterUsername(String username) {
	        driver.findElement(usernameField).sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickLogin() {
	        driver.findElement(loginBtn).click();
	    }

	    public boolean isErrorDisplayed() {
	        return driver.findElement(errorMsg).isDisplayed();
	    }
	}
