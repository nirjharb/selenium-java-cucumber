package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class loginPage {

    WebDriver driver;

    // Locators for the login page
    private By usernameField = By.cssSelector("input[placeholder='username']");
    private By passwordField = By.cssSelector("input[placeholder='password']");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.xpath("//p[text()='Invalid credentials']");

    // Constructor to initialize WebDriver and the page elements
    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to open the login page
    public void openLoginPage(String url) {
        driver.get(url);
    }

    // Method to enter username
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Method to get the error message text
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    // Method to wait for the login page to load completely
    public void waitForLoginPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
    }

    // Method to perform login
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    // Close the browser
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}

