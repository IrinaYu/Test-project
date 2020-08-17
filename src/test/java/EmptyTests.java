import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

public class EmptyTests {
  WebDriver driver = null;

  @BeforeMethod
  public void beforeMethod() {
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
    System.out.println("BeforeMethod");
  }

  @Test
  public void test1() {
    assert 1==1;
    System.out.println("test1");
  }

  @Test
  public void test2() {
    assert 1!=0;
    System.out.println("test2");
  }

  @AfterMethod
  public void tearDown() {
    System.out.println( "AfterMethod");
    WebDriverFactory.getDriver().quit();
  }
}
