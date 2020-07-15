import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateIssuePage;
import pages.HomePage;
import pages.LoginPage;
import pages.TicketPage;
import utils.WebDriverFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateIssue {

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
    public void createIssue() {
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

    }

    @AfterMethod()
    public void tearDown() {
      WebDriverFactory.getDriver().quit();
    }

  }