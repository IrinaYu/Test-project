import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

public class TestWithParametrs {

  WebDriver driver = null;

  @Parameters({"waitTimeOutInSeconds"})

  @BeforeMethod
  public void setUp() {
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
  }

  @Test
  public static void testWithParametrsInListener() {
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
