package org.task3_1.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertUtils {

    public static Alert getAlert() {
        WebDriver driver = WebDriverUtils.getDriver();
        WaitUtils.waitForAlert();
        return driver.switchTo().alert();
    }

    public static String getAlertText(Alert alert) {
        LogUtils.logInfo("Getting text from an alert");
        return alert.getText();
    }

    public static void acceptAlert(Alert alert) {
        LogUtils.logInfo("Clicking 'OK' in an alert");
        alert.accept();
    }

    public static void setAlertInputText(Alert alert, String text) {
        LogUtils.logInfo("Sending " + text + " to an alert");
        alert.sendKeys(text);
    }

    public static boolean isAlertPresent() {
        WebDriver driver = WebDriverUtils.getDriver();
        LogUtils.logInfo("Checking if any alert is present");
        try{
            driver.switchTo().alert();
            return true;
        }
        catch(NoAlertPresentException ex){
            return false;
        }
    }
}
