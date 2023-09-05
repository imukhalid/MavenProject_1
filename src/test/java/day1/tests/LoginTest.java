package day1.tests;

import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.example.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTest {
    WebDriver driver;
    DriverManager.BrowserType type = DriverManager.BrowserType.CHROME_WIN;
    LoginPage loginPageObj;
    DashboardPage dashboardPageObj;

    @BeforeTest
    public void setup(){
        driver = DriverManager.getDriver(type);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        loginPageObj = new LoginPage(driver);
        dashboardPageObj = new DashboardPage(driver);
    }

    @AfterTest
    public void TearDown(){
        driver.quit();
    }

    @Test
    public void login_with_valid_credentials() throws InterruptedException {
        driver.get(LoginPage.PAGE_URL);
        assertTrue(driver.getTitle().contains(LoginPage.PAGE_TITLE));
        String ActualText = loginPageObj.loginPageText();
        String ExpectedText = "Sign in to start your session";
        Assert.assertEquals(ActualText, ExpectedText);
        loginPageObj.enterUsername("usamakhalid889@gmail.com");
        loginPageObj.enterPassword("Admin@1234");
        loginPageObj.clickLoginButton();
        String dashboardActualText = dashboardPageObj.dashboardPageText();
        String dashboardExpectedText = "Dashboard Version 2.0";
        Assert.assertEquals(dashboardActualText, dashboardExpectedText);
        Thread.sleep(2000);
    }



}
