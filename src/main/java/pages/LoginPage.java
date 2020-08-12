package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class LoginPage {

  private WebDriver driver;

  private By userNameInput = By.id("login-form-username");
  private By passwordInput = By.id("login-form-password");
  private By loginButton = By.id("login");
  //private String message = "Sorry, your username and password are incorrect - please try again.";
  private By errorMessage = By.id("usernameerror");


  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public void enterUserName(String name) {
    userNameInput.findElement(driver).sendKeys(name);
  }

  public void enterPassword(String password) {
    driver.findElement(passwordInput).sendKeys(password);
  }

  public void clickLogin() {
    driver.findElement(loginButton).click();
  }

  public void navigateTo() {
    driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
  }

  public boolean errorMessageIsPresent() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60).getSeconds());
    return wait.until(presenceOfElementLocated(errorMessage)).isDisplayed();
  }

}
