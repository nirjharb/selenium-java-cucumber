package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {

    WebDriver driver;

    // Locators for the login page
    By usernameField = By.cssSelector("input[name='username']");
    By passwordField = By.cssSelector("input[name='password']");
    By loginButton = By.cssSelector("button[type='submit']");
    By invalidCredMessage = By.cssSelector("div[role='alert']");
    By requiredText1 = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");
    By requiredText2 = By.xpath("//div[@class='orangehrm-login-form']//div[2]//div[1]//span[1]");

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

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredMessage));
            return driver.findElement(invalidCredMessage).getText();
        } catch (TimeoutException e1) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(requiredText1));
                return driver.findElement(requiredText1).getText();
            } catch (TimeoutException e2) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(requiredText2));
                return driver.findElement(requiredText2).getText();
            }
        }
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

