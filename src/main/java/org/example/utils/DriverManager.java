package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {
    public enum BrowserType {
        CHROME_WIN,
        CHROME_MAC,
        FIREFOX_WIN,
        FIREFOX_MAC
    }

    public static WebDriver getDriver(BrowserType type) {
        WebDriver driver = null;
        String driverPath = "C:\\Users\\a2z\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe";
        switch (type){
            case CHROME_WIN, CHROME_MAC:
                driver = createChromeDriver();
                break;
            case FIREFOX_WIN, FIREFOX_MAC:
                driver = createFirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + type);
        }
        return driver;
    }

    private static WebDriver createChromeDriver() {
        String driverPath = "C:\\Users\\a2z\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        return new ChromeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        String driverPath = "C:\\path\\to\\geckodriver.exe"; // Provide the path to your GeckoDriver executable
        System.setProperty("webdriver.gecko.driver", driverPath);
        FirefoxOptions options = new FirefoxOptions();
        // Add any Firefox-specific options if needed
        return new FirefoxDriver(options);
    }
}
