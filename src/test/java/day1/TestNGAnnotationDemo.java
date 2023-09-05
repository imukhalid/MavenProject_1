package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGAnnotationDemo {

    public String baseURL = "https://nxtgenaiacademy.com/alertandpopup/";
    String driverPath = "C:\\Users\\a2z\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe";
    public WebDriver driver;

    @BeforeTest
    public void launch_chrome_browser(){
        System.out.println("Starting Chrome Browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    @Test(priority  = 1)
    public void verify_home_page_title(){
        driver.get(baseURL);
        String expectedTitle = "Demo Site – Alert and Popup – NxtGen A.I Academy";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test(priority  = 2)
    public void verify_drag_and_drop_feature() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions builder = new Actions(driver);
        Thread.sleep(2000);
        builder.dragAndDrop(source, target).build().perform();
        Thread.sleep(2000);
    }

    @Test(dataProvider = "getData")
    public void data_provider_demo(String username, String password){
        System.out.println("Your User Name is :"+username);
        System.out.println("Your Password is :"+password);
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[3][2];

        //Ist Row
        data[0][0] = "user1";
        data[0][1] = "admin";

        //2nd Row
        data[1][0] = "user2";
        data[1][1] = "myPassword";

        //3rd Row
        data[2][0] = "user3";
        data[2][1] = "hello";

        return data;
    }

    @AfterTest
    public void close_browser(){
        driver.close();
    }


}
