import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

public class TestWithParameters {

  WebDriver driver = null;

  @Parameters({"browserName"})

  @BeforeMethod
  public void setUp() {
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
  }
 
  @Test
  public static void testWithParameters() {
  }

  @AfterMethod()
  public void tearDown() {
    WebDriverFactory.getDriver().quit();
  }
}
