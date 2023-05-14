package org.task3_1.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserUtils {
    public static void scrollToElement(By elementBy, String name) {
        WebDriver driver = WebDriverUtils.getDriver();
        WaitUtils.waitToBePresent(elementBy);
        WebElement element = driver.findElement(elementBy);
        LogUtils.logInfo("Scrolling to the element " + name);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void switchToNextTab(int tabsCount) {
        WebDriver driver = WebDriverUtils.getDriver();
        String originalWindow = driver.getWindowHandle();
        WaitUtils.waitToOpenNewTab(tabsCount);
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                LogUtils.logInfo("Switching to the next tab!");
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void closeTab() {
        WebDriver driver = WebDriverUtils.getDriver();
        LogUtils.logInfo("Closing a tab");
        driver.close();
    }

    public static void switchToTab(String windowHandle) {
        WebDriver driver = WebDriverUtils.getDriver();
        LogUtils.logInfo("Switching to a tab with handle " + windowHandle);
        driver.switchTo().window(windowHandle);
    }

    public static void switchToFrame(By frameBy, String name) {
        WebDriver driver = WebDriverUtils.getDriver();
        WaitUtils.waitToBePresent(frameBy);
        WebElement frame = driver.findElement(frameBy);
        LogUtils.logInfo("Switching to the " + name + " frame");
        driver.switchTo().frame(frame);
    }

    public static void switchToDefaultContent() {
        WebDriver driver = WebDriverUtils.getDriver();
        LogUtils.logInfo("Switching to the default content");
        driver.switchTo().defaultContent();
    }

    public static String getTabHandle(){
        WebDriver driver = WebDriverUtils.getDriver();
        return driver.getWindowHandle();
    }

    public static int getTabsCount() {
        WebDriver driver = WebDriverUtils.getDriver();
        return driver.getWindowHandles().size();
    }
}
