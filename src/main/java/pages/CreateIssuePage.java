package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class CreateIssuePage {

  private WebDriver driver;

  private By projectNameField = By.id("project-field");
  private By issueTypeField = By.id("issuetype-field");
  private By summaryField = By.id("summary");
  private By reporterField = By.id("reporter-field");
  private By submitButton = By.id("create-issue-submit");
  private By popUpSuccessfulCreate = By.xpath("//*[@id='aui-flag-container']/div");
  private By issueLink = By.cssSelector("#aui-flag-container>div>div>a");

  public CreateIssuePage(WebDriver driver) {
    this.driver = driver;
  }

  //waiting until elements are clickable or displayed
  public boolean projectFieldIsClickable() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());
    return wait.until(elementToBeClickable(projectNameField)).isDisplayed();
  }

  public boolean issueTypeFieldIsClickable() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());
    return wait.until(elementToBeClickable(issueTypeField)).isDisplayed();
  }

  public boolean summaryFieldIsClickable() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());
    return wait.until(elementToBeClickable(summaryField)).isDisplayed();
  }

  public boolean reporterFieldIsClickable() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());
    return wait.until(elementToBeClickable(reporterField)).isDisplayed();
  }

  public boolean popUpIssueName() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());
    return wait.until(presenceOfElementLocated(popUpSuccessfulCreate)).isDisplayed();
  }

  //clearing fields
  public void clearProjectField() {
    driver.findElement(projectNameField).clear();
  }

  public void clearIssueTypeField() {
    driver.findElement(issueTypeField).clear();
  }

  public void clearReporterField() {
    driver.findElement(reporterField).clear();
  }

  //sending string keys
  public void enterProjectName(String projectName) {
    driver.findElement(projectNameField).sendKeys(projectName);
  }

  public void enterIssueTypeName(String issueTypeName) {
    driver.findElement(issueTypeField).sendKeys(issueTypeName);
  }

  public void enterSummaryName(String summaryName) {
    driver.findElement(summaryField).sendKeys(summaryName);
  }

  public void enterReporterName(String reporterName) {
    driver.findElement(reporterField).sendKeys(reporterName);
  }

  //sending TAB to fields
  public void tabProjectName() {
    driver.findElement(projectNameField).sendKeys(Keys.TAB);
  }

  public void tabIssueType() {
    driver.findElement(issueTypeField).sendKeys(Keys.TAB);
  }

  public void tabReporter() {
    driver.findElement(reporterField).sendKeys(Keys.TAB);
  }

  //clicking
  public void clickSubmit() {
    driver.findElement(submitButton).click();
  }

  public void clickLinkIssue() {
    driver.findElement(issueLink).click();
  }

}
