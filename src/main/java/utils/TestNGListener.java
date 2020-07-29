package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestNGListener implements ITestListener {
  WebDriver driver = null;
  LoginPage loginPage = null;

  @Override
  // Запускается один раз перед каждым тестом
  public void onTestStart(ITestResult result) {
//    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
    loginPage = new LoginPage(driver);
    String browserName = result.getTestContext().getCurrentXmlTest().getParameter("browserName");
    System.out.println("OnTestStart");
//    System.out.println("Browser name is " + browserName);

  }

  @Override
  public void onTestSuccess(ITestResult result) {
    System.out.println("OnTestSuccess");
  }

  @Override
  public void onTestFailure(ITestResult result) {
    File screenshotsFolder = new File(System.getProperty("user.dir") + "/screenshots");

    if (!screenshotsFolder.exists()) {
      screenshotsFolder.mkdir();
    }

    File screenshot = captureScreenshot();
    Path pathToScreenShot = Paths.get(screenshot.getPath());
    try {
      String screenshotName = screenshotsFolder + "/" + "Screenshot_" + java.time.LocalTime.now() + ".png";
      Files.copy(pathToScreenShot, Paths.get(screenshotName), StandardCopyOption.COPY_ATTRIBUTES);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("OnTestFailure");
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    System.out.println("OnTestSkipped");
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    System.out.println("OnTestFailedButWithinSuccessPercentage");
  }

  @Override
  //Запускается один раз перед тестом
  public void onStart(ITestContext context) {
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
    loginPage = new LoginPage(driver);
    System.out.println("OnStart");
  }

  @Override
  public void onFinish(ITestContext context) {
    driver.quit();
    System.out.println("OnFinish");
  }

  private File captureScreenshot() {
    return ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
  }
}
