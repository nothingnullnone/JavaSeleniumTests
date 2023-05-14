package org.task3_1.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class WaitUtils {
    private static final int seconds = ((Long) FileReadUtils.getField(Filenames.configFile, "time_to_wait")).intValue();
    public static void waitToBeVisible(By webElementBy) {
        WebDriver driver = WebDriverUtils.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(webElementBy));
    }

    public static void waitFrameToSwitch(By webElementBy) {
        WebDriver driver = WebDriverUtils.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webElementBy));
    }

    public static void waitToBeInvisible(By webElementBy) {
        WebDriver driver = WebDriverUtils.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(webElementBy));
    }

    public static void waitToBePresent(By webElementBy) {
        WebDriver driver = WebDriverUtils.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(webElementBy));
    }

    public static void waitToBeClickable(By webElementBy) {
        WebDriver driver = WebDriverUtils.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(webElementBy));
    }

    public static void waitElementToHaveAttribute(By webElementBy, String attribute, String text) {
        WebDriver driver = WebDriverUtils.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.attributeToBe(webElementBy, attribute, text));
    }

    public static void waitElementToHaveText(By webElementBy, String text) {
        WebDriver driver = WebDriverUtils.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.textToBe(webElementBy, text));
    }

    public static void waitToOpenNewTab(int tabsCount) {
        WebDriver driver = WebDriverUtils.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(numberOfWindowsToBe(tabsCount + 1));
    }

    public static void waitForAlert() {
        WebDriver driver = WebDriverUtils.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
