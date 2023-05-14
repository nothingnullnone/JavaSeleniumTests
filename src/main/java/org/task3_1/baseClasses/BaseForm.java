package org.task3_1.baseClasses;

import org.openqa.selenium.*;
import org.task3_1.utils.*;

public abstract class BaseForm {
    protected By uniqueElementBy;
    protected String formName;
    protected WebDriver driver = WebDriverUtils.getDriver();

    protected BaseForm(By locator, String name) {
        uniqueElementBy = locator;
        formName = name;
    }

    public By getLocator() {
        return uniqueElementBy;
    }

    public String getFormName() {
        return formName;
    }

    public boolean isFormPresent() {
        LogUtils.logInfo("Checking if the form " + formName + " is present");
        WaitUtils.waitToBePresent(uniqueElementBy);
        return true;
    }

    public boolean isFormVisible() {
        LogUtils.logInfo("Checking if the form " + formName + " is visible");
        WaitUtils.waitToBeVisible(uniqueElementBy);
        return true;
    }

    public boolean isFormInvisible() {
        LogUtils.logInfo("Checking if the form " + formName + " is invisible");
        WaitUtils.waitToBeInvisible(uniqueElementBy);
        return true;
    }

}
