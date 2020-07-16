import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestWithParametrs {

  @Parameters({"waitTimeOutInSeconds"})
  @Test
  public static void testWithParametrsAnnotation(String waitTimeOutInSeconds) {
    System.out.println("Timeout " + waitTimeOutInSeconds);
  }

  @Test
  public static void testWithParametrsInListener() {
  }
}
