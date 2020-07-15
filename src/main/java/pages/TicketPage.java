package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class TicketPage {

  private WebDriver driver;

  private By createCommentButton = By.cssSelector("#footer-comment-button");
  private By commentField = By.id("comment-wiki-edit");
  private By textTab = By.xpath("//*[@id=\"comment-wiki-edit\"]/nav/div/div/ul/li[2]/a");
  private By textInput = By.id("comment");
  private By typeIssue = By.xpath("//*[@id='issuedetails']//child::*[@id='type-val']");
  private By issueLink = By.cssSelector("a#key-val.issue-link");


  public TicketPage(WebDriver driver) {
    this.driver = driver;
  }

  //waiting until elements are clickable or displayed
  public boolean commentButtonIsClickable() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());
    return wait.until(elementToBeClickable(createCommentButton)).isDisplayed();
  }

  public boolean commentFieldIsClickable() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());
    return wait.until(elementToBeClickable(commentField)).isDisplayed();
  }
  public boolean textInputFieldIsPresent() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());
    return wait.until(presenceOfElementLocated(textInput)).isDisplayed();
  }
  public String getTextInputValue() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());
    return wait.until(presenceOfElementLocated(textInput)).getAttribute("value");
  }

  public boolean issueTypeIsDysplayed() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());
    return wait.until(presenceOfElementLocated(typeIssue)).isDisplayed();
  }



  //clearing fields
  public void clearTextField() {
    driver.findElement(textInput).clear();
  }

  //sending string keys
  public void enterComment (String comment) {
    driver.findElement(textInput).sendKeys(comment);
  }


  //clicking
  public void clickCommentButton() {
    driver.findElement(createCommentButton).click();
  }

  public void clickTextTab() {
    driver.findElement(textTab).click();
  }

  //getting attribute
  public String getIssueLink () {
    return(driver.findElement(issueLink).getAttribute("href"));
  }
}