package org.task3_1.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.task3_1.baseClasses.BaseElement;
import org.task3_1.utils.LogUtils;

public class TextBox extends BaseElement {
    public TextBox(By locator, String name) {
        super(locator, name);
    }

    public void enterText(String text) {
        if (isElementPresent()) {
            WebElement element = driver.findElement(elementLocatorBy);
            LogUtils.logInfo("Entering " + text + " into the text box "+ elementName);
            element.sendKeys(text);
        }
    }

    public void clearInput() {
        if (isElementPresent()) {
            WebElement element = driver.findElement(elementLocatorBy);
            LogUtils.logInfo("Clearing the text box "+ elementName);
            element.clear();
        }
    }
}
