import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;

import static org.testng.Assert.assertTrue;

public class LoginToJira2 {
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

  @DataProvider(name = "loginNegative")
  public Object[][] createData1() {
    return new Object[][]{
        {"SomeName", "IrynaKapustina", "Sorry, your username and password are incorrect - please try again."},
        {"SomeName", "SomePassword", "Sorry, your username and password are incorrect - please try again."},
        {"IrynaKapustina", "SomePassword", "Sorry, your username and password are incorrect - please try again."},

    };
  }

  @Test(dataProvider = "loginNegative")
  public void unsuccessfulLoginTest(String name, String password, String expectedResult) throws InterruptedException{
    loginPage.navigateTo();
    loginPage.enterUserName(name);
    loginPage.enterPassword(password);
    loginPage.clickLogin();

    //TODO - add check "Sorry, your username and password are incorrect - please try again."
    assertTrue(loginPage.errorMessageIsPresent(expectedResult));
  }

  @Test
  public void successfulLoginTest() {
    loginPage.navigateTo();
    loginPage.enterUserName("webinar5");
    loginPage.enterPassword("webinar5");
    loginPage.clickLogin();
    assertTrue(homePage.userNameIsPresent());

    //TODO log out
  }

  @AfterMethod()
  public void tearDown() {
    WebDriverFactory.getDriver().quit();
  }
}