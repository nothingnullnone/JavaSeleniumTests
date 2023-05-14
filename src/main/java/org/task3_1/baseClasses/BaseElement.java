package org.task3_1.baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.task3_1.utils.*;

public abstract class BaseElement {
    protected By elementLocatorBy;
    protected String elementName;
    protected WebDriver driver = WebDriverUtils.getDriver();

    protected BaseElement(By locator, String name) {
        elementLocatorBy = locator;
        elementName = name;
    }

    public By getLocator() {
        return elementLocatorBy;
    }

    public String getElementName() {
        return elementName;
    }

    public boolean isElementPresent() {
        WaitUtils.waitToBePresent(elementLocatorBy);
        return true;
    }

    public void click() {
        WaitUtils.waitToBeClickable(elementLocatorBy);
        WebElement element = driver.findElement(elementLocatorBy);
        LogUtils.logInfo("Clicking an element " + elementName);
        element.click();
    }

    public String getText() {
        if (isElementPresent()) {
            WebElement element = driver.findElement(elementLocatorBy);
            LogUtils.logInfo("Getting text from the element " + elementName);
            return element.getText();
        }
        return "";
    }
}
