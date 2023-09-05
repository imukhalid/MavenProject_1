package day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumDemo  implements WebDriverListener {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\a2z\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        // implicit wait -- global timeout -- for every element if find element let say in 10 min other 20 min will be skipped
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

//        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[1]/p[1]/input"));
//        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[1]/p[2]/input"));
//        WebElement HomeLink = driver.findElement(By.linkText("Home"));
//
//        fillForm(driver, firstName, 100000, "First Name");
//        fillForm(driver, lastName, 10, "Last Name");
//
//        clickOn(driver, HomeLink, 40);

        // Handling Alerts in selenium
        // SIMPLE ALERT, PROMPT ALERT, CONFIRMATION ALERT
        driver.get("http://localhost/automationpractice/index.php");
        //WebElement alertBtn = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[1]/div/section[3]/div/div[1]/div/div/div/center/button"));
        //alertBtn.click();
        //Alert alert = driver.switchTo().alert();
        //String alertMsg = driver.switchTo().alert().getText();
        //System.out.println("*****************************************************************");
        //System.out.println(alertMsg);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.switchTo().alert().accept();

        // Simple Alert
//        WebElement alertBtn = driver.findElement(By.xpath("//button[@name='alertbox']"));
//        alertBtn.click();
//        String alertText = driver.switchTo().alert().getText();
//        System.out.println(alertText);
//        driver.switchTo().alert().accept();

        // Confirm Alert
//        WebElement confirmAlertBtn = driver.findElement(By.xpath("//button[@name='confirmalertbox']"));
//        confirmAlertBtn.click();
//        String confirmAlerText = driver.switchTo().alert().getText();
//        System.out.println(confirmAlerText);
//        driver.switchTo().alert().accept();   // Accept OR
//        driver.switchTo().alert().dismiss();  // Dismiss

        // Prompt Alert
//        WebElement promptAlertBtn = driver.findElement(By.xpath("//button[@name=\"promptalertbox1234\"]"));
//        promptAlertBtn.click();
//        String confirmAlerText = driver.switchTo().alert().getText();
//        System.out.println(confirmAlerText);
//        //driver.switchTo().alert().sendKeys("Yes"); // Send Value and accept
//        //driver.switchTo().alert().accept();  // OR
//        driver.switchTo().alert().dismiss();

    }
    // For Explicit Wait -- Form filing
    public static void fillForm(WebDriver driver, WebElement element, int timeoutSeconds, String value) {
        Duration timeout = Duration.ofSeconds(timeoutSeconds);
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    // For Explicit Wait -- For clicking
    public static void clickOn(WebDriver driver, WebElement element, int timeoutSeconds){
        Duration timeout = Duration.ofSeconds(timeoutSeconds);
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}


/*
-----------------
Waits in selenium [All of them are dynamic in nature]

Implicit wait
Explicit wait
Fluent wait
-----------------
Handling js-pop-ups

Simple Alert
Prompt Alert
Confirm Alert

 */
