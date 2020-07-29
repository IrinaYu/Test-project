import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmptyTests {

  @BeforeMethod
  public void beforeMethod() {
    System.out.println("BeforeMethod");
  }

  @Test
  public void test1() {
    assert 1 == 1;
    System.out.println("test1");
  }

  @Test
  public void test2() {
    assert 1 == 1;
    System.out.println("test2");
  }

  @AfterMethod
  public void afterMethod() {
    System.out.println( "AfterMethod");
  }
}
