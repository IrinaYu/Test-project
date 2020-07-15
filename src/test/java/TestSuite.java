import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CreateIssuePage;
import pages.HomePage;
import pages.LoginPage;
import pages.TicketPage;
import utils.WebDriverFactory;

import static org.testng.Assert.assertTrue;

public class TestSuite {
  WebDriver driver = null;
  LoginPage loginPage = null;
  HomePage homePage = null;
  CreateIssuePage createIssuePage = null;
  TicketPage ticketPage = null;

  @BeforeMethod
  public void setUp() {
    // Open the browser
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    createIssuePage = new CreateIssuePage(driver);
    ticketPage = new TicketPage(driver);
  }


  @Test
  public void LoginTest() {
    loginPage.navigateTo();
    loginPage.enterUserName("IrynaKapustina");
    loginPage.enterPassword("IrynaKapustina");
    loginPage.clickLogin();
    assertTrue(homePage.userNameIsPresent());

  }

  @Test
  public void ViewJIRATicket() {
    loginPage.navigateTo();
    loginPage.enterUserName("IrynaKapustina");
    loginPage.enterPassword("IrynaKapustina");
    loginPage.clickLogin();

    assertTrue(homePage.userNameIsPresent());
    homePage.clickCreate();

    assertTrue(createIssuePage.projectFieldIsClickable());
    createIssuePage.clearProjectField();
    createIssuePage.enterProjectName("Webinar (WEBINAR)");
    createIssuePage.tabProjectName();

    assertTrue(createIssuePage.issueTypeFieldIsClickable());
    createIssuePage.clearIssueTypeField();
    createIssuePage.enterIssueTypeName("Задача");
    createIssuePage.tabIssueType();


    assertTrue(createIssuePage.summaryFieldIsClickable());
    createIssuePage.enterSummaryName("Some summary");


    assertTrue(createIssuePage.reporterFieldIsClickable());
    createIssuePage.clearReporterField();
    createIssuePage.enterReporterName("IrynaKapustina");
    createIssuePage.tabReporter();

    createIssuePage.clickSubmit();

    assertTrue(createIssuePage.popUpIssueName());

    //going to just created ticket from pop up
    createIssuePage.clickLinkIssue();

    assertTrue(ticketPage.commentButtonIsClickable());

    //making sure the type issue is displayed
    assertTrue(ticketPage.issueTypeIsDysplayed());

    //making sure the URL contains of ticket ID
    String URL = driver.getCurrentUrl();
    String IDTicket = ticketPage.getIssueLink();
    Assert.assertEquals(URL, IDTicket);

  }

  @Test
  public void AddComment() {
    loginPage.navigateTo();
    loginPage.enterUserName("IrynaKapustina");
    loginPage.enterPassword("IrynaKapustina");
    loginPage.clickLogin();

    assertTrue(homePage.userNameIsPresent());
    homePage.clickCreate();

    assertTrue(createIssuePage.projectFieldIsClickable());
    createIssuePage.clearProjectField();
    createIssuePage.enterProjectName("Webinar (WEBINAR)");
    createIssuePage.tabProjectName();

    assertTrue(createIssuePage.issueTypeFieldIsClickable());
    createIssuePage.clearIssueTypeField();
    createIssuePage.enterIssueTypeName("Задача");
    createIssuePage.tabIssueType();


    assertTrue(createIssuePage.summaryFieldIsClickable());
    createIssuePage.enterSummaryName("Some summary");


    assertTrue(createIssuePage.reporterFieldIsClickable());
    createIssuePage.clearReporterField();
    createIssuePage.enterReporterName("IrynaKapustina");
    createIssuePage.tabReporter();

    createIssuePage.clickSubmit();
    assertTrue(createIssuePage.popUpIssueName());


    //going to just created ticket from pop up
    createIssuePage.clickLinkIssue();
    assertTrue(ticketPage.commentButtonIsClickable());

    //clicking on the button "comment" and  finding comment input
    ticketPage.clickCommentButton();
    assertTrue(ticketPage.commentFieldIsClickable());
    ticketPage.clickTextTab();
    assertTrue(ticketPage.textInputFieldIsPresent());

    //inputting of comment and ckecking for text "Some comment"
    ticketPage.clearTextField();
    ticketPage.enterComment("Some comment");

    String myComment = ("Some comment");
    String typedComment = ticketPage.getTextInputValue();
    Assert.assertEquals(myComment, typedComment);

    //clearing the comment and checking if the input field is clear
    ticketPage.clearTextField();

    String clearedInputField = ticketPage.getTextInputValue();
    //wait.until(presenceOfElementLocated(By.id("comment"))).getAttribute("value");
    Assert.assertNotEquals(clearedInputField, myComment);
  }

  @AfterMethod()
  public void tearDown() {
    WebDriverFactory.getDriver().quit();
  }

}

