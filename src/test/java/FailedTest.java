import org.openqa.selenium.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.WebDriverFactory;

import static org.testng.Assert.assertEquals;


public class FailedTest {

  WebDriver driver = null;
  LoginPage loginPage = null;

  @BeforeMethod
  public void setUp() {
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();

    loginPage = new LoginPage(driver);
  }

  @Test
  public void failedTest() {
    loginPage.navigateTo();
    assertEquals(1, 2);
  }


  @AfterMethod
  public void tearDown() {

    WebDriverFactory.getDriver().quit();
  }
}
