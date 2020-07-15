
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.CreateIssuePage;
import pages.HomePage;
import pages.LoginPage;
import pages.TicketPage;
import utils.WebDriverFactory;


import static org.testng.Assert.assertTrue;

public class LoginToJira {
  WebDriver driver = null;
  LoginPage loginPage = null;
  HomePage homePage = null;

  @BeforeMethod
  public void setUp() {
    // Open the browser
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
  }

  @Test
  public void LoginTest() {
    loginPage.navigateTo();
    loginPage.enterUserName("IrynaKapustina");
    loginPage.enterPassword("IrynaKapustina");
    loginPage.clickLogin();
    assertTrue(homePage.userNameIsPresent());
  }

  @AfterMethod()
  public void tearDown() {
    WebDriverFactory.getDriver().quit();
  }
}