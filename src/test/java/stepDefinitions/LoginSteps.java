package stepDefinitions;

import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;
import utils.DriverFactory;
import utils.ExcelUtils;


public class LoginSteps {
	
	LoginPage loginPage;
    DashboardPage dashboardPage;
    List<String[]> excelData;

    @Given("user is on OrangeHRM login page")
    public void user_is_on_orangehrm_login_page() {
        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(DriverFactory.getDriver());
        dashboardPage = new DashboardPage(DriverFactory.getDriver());
    }

    @When("user login using Excel sheet data")
    public void user_login_using_excel_sheet_data() throws InterruptedException {
        excelData = ExcelUtils.getLoginData();
    }

    @Then("login results should be validated")
    public void login_results_should_be_validated() throws InterruptedException {

        for (String[] row : excelData) {

            String username = row[0];
            String password = row[1];
            String expected = row[2];

            DriverFactory.getDriver().navigate().refresh();
            Thread.sleep(2000);

            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.clickLogin();

            Thread.sleep(2000);

            if (expected.equalsIgnoreCase("Valid")) {
                Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Valid login failed for user: " + username);
            } else {
                Assert.assertTrue(loginPage.isErrorDisplayed(), "Invalid login error not displayed for user: " + username);
            }
        }
    }
}