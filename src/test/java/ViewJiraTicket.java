import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateIssuePage;
import pages.HomePage;
import pages.LoginPage;
import pages.TicketPage;
import utils.WebDriverFactory;
import static org.testng.Assert.assertTrue;

public class ViewJiraTicket {

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
    assertTrue (ticketPage.issueTypeIsDysplayed());

    //making sure the URL contains of ticket ID
    String URL = driver.getCurrentUrl();
    String IDTicket = ticketPage.getIssueLink();
    Assert.assertEquals(URL, IDTicket);

  }

  @AfterMethod()
  public void tearDown() {
    WebDriverFactory.getDriver().quit();
  }

}