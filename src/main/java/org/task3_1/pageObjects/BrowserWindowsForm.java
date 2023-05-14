package org.task3_1.pageObjects;

import org.openqa.selenium.By;
import org.task3_1.baseClasses.BaseForm;
import org.task3_1.webElements.Button;

public class BrowserWindowsForm extends BaseForm {
    private final Button buttonNewTab = new Button(By.xpath("//button[@id='tabButton']"), "buttonNewTab");
    public BrowserWindowsForm() {
        super(By.xpath("//div[@id='browserWindows']"), "browserWindowsForm");
    }

    public void clickButtonNewTab() {
        buttonNewTab.click();
    }
}
