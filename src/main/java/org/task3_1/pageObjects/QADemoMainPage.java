package org.task3_1.pageObjects;

import org.openqa.selenium.By;
import org.task3_1.baseClasses.BaseForm;
import org.task3_1.webElements.Button;

public class QADemoMainPage extends BaseForm {
    private final Button buttonAlertsFrameWindows = new Button(By.xpath("//div[@class='category-cards']//*[text() = 'Alerts, Frame & Windows']"), "buttonAlertsFrameWindows");
    private final Button buttonElements = new Button(By.xpath("//div[@class='category-cards']//*[text() = 'Elements']"), "buttonElements");

    public QADemoMainPage(){
        super(By.xpath("//div[@class='category-cards']"), "mainPage");
    }

    public void clickButtonAlertsFrameWindows() {
        buttonAlertsFrameWindows.click();
    }

    public void clickButtonElements() {
        buttonElements.click();
    }

}
