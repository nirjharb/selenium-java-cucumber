package stepDefinition;

import io.cucumber.java.After;
import pages.loginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Objects;

public class loginSteps {

    WebDriver driver;
    loginPage loginPage;

    @Given("I am on the OrangeHRM login page")
    public void i_am_on_the_orangehrm_login_page() {

        // Set up WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Create instance of the LoginPage class
        loginPage = new loginPage(driver);

        // Open the OrangeHRM login page
        loginPage.openLoginPage("https://opensource-demo.orangehrmlive.com/auth/login");

        // Wait for the page to load
        loginPage.waitForLoginPageToLoad();
    }

    @When("I enter a valid username {string}")
    public void i_enter_a_valid_username(String username) {
        loginPage.enterUsername(username);
    }

    @And("I enter a valid password {string}")
    public void i_enter_a_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("I enter an invalid username {string}")
    public void i_enter_an_invalid_username(String username) {
        loginPage.enterUsername(username);
    }

    @And("I enter an invalid password {string}")
    public void i_enter_an_invalid_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("I leave the username field blank")
    public void i_leave_the_username_field_blank() {
        loginPage.enterUsername("");
    }

    @And("I leave the password field blank")
    public void i_leave_the_password_field_blank() {
        loginPage.enterPassword("");
    }

    @When("I click on the {string} button")
    public void i_click_on_the_login_button(String button) {
        if (button.equalsIgnoreCase("Login")) {
            loginPage.clickLoginButton();
        }
    }

    @Then("I should be redirected to the {string} page")
    public void i_should_be_redirected_to_the_dashboard_page(String pageName) {

        // Validate if the current URL contains the expected page
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl != null;
        Assert.assertTrue(currentUrl.contains(pageName.toLowerCase()), "User is not redirected to " + pageName + " page");
    }

    @Then("I should see the {string} text on the page")
    public void i_should_see_the_dashboard_message(String message) throws InterruptedException {
        Thread.sleep(3000);
        // Validate that the dashboard message is displayed
        Assert.assertTrue(Objects.requireNonNull(driver.getPageSource()).contains(message), "Welcome message is not displayed.");
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedMessage) {

        // Validate if the error message matches the expected message
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedMessage, "Error message does not match");
    }

    @After
    public void closeBrowser() {
        // Close the browser after the tests
        loginPage.closeBrowser();
    }
}