import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SampleSelenideTest {


  @BeforeMethod
  public void setUp(){
    Configuration.browser = "firefox";
  }

  @Test
  public void loginTest(){
    open("https://jira.hillel.it/secure/Dashboard.jspa");
    $(By.id("login-form-username")).setValue("webinar5");
    $(By.id("login-form-password")).setValue("webinar5");
    $("#login").click();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}