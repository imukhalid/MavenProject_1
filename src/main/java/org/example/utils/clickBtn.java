package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class clickBtn {
    public static void clickOn(WebDriver driver, WebElement element, int timeoutSeconds){
        Duration timeout = Duration.ofSeconds(timeoutSeconds);
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
