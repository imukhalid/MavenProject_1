package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.utils.clickBtn;

public class LoginPage extends BasePage{
    public static final String PAGE_TITLE = "AutoSync";
    public static final String PAGE_URL = "http://localhost/automationpractice/index.php";
    WebDriver driver;
    clickBtn clickBtnObj;

    @FindBy(xpath = "//input[@name='email']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@name='submit']")
    WebElement loginButton;

    @FindBy(xpath = "(//p['login-box-msg'])[1]")
    WebElement loginPageText;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); // Initialize elements using Page Factory
    }

    // Page actions
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
//        clickBtn.clickOn(driver, loginButton ,40);
    }

    public String loginPageText() {
        WebElement heading = loginPageText;
        return heading.getText();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
