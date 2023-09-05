package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage{
    public static final String PAGE_TITLE = "AutoSync | Dashboard";
    public static final String PAGE_URL = "http://localhost/automationpractice/pages/dashboard.php";
    WebDriver driver;

    @FindBy(xpath = "//section/h1")
    WebElement dashboardPageText;

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); // Initialize elements using Page Factory
    }
    public String dashboardPageText() {
        WebElement heading = dashboardPageText;
        return heading.getText();
    }
}
