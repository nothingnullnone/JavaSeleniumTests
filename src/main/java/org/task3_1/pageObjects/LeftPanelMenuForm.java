package org.task3_1.pageObjects;

import org.openqa.selenium.By;
import org.task3_1.baseClasses.BaseForm;
import org.task3_1.utils.BrowserUtils;
import org.task3_1.webElements.Button;

public class LeftPanelMenuForm extends BaseForm {
    private final Button buttonLeftPanelElements = new Button(By.xpath("//div[@class='left-pannel']//div[text()='Elements']"), "buttonLeftPanelElements");
    private final Button buttonAlerts = new Button(By.xpath("//li[contains(@class, 'btn')]//span[contains(text(), 'Alerts')]"), "buttonAlerts");
    private final Button buttonNestedFrames = new Button(By.xpath("//li[contains(@class, 'btn')]//span[contains(text(), 'Nested')]"), "buttonNestedFrames");
    private final Button buttonFrames = new Button(By.xpath("//li[contains(@class, 'btn')]//span[(text() = 'Frames')]"), "buttonFrames");
    private final Button buttonWebTables = new Button(By.xpath("//li[contains(@class, 'btn')]//span[(text() = 'Web Tables')]"), "buttonWebTables");
    private final Button buttonBrowserWindows = new Button(By.xpath("//li[contains(@class, 'btn')]//span[(text() = 'Browser Windows')]"), "buttonBrowserWindows");
    private final Button buttonLinks = new Button(By.xpath("//li[contains(@class, 'btn')]//span[(text() = 'Links')]"), "buttonLinks");

    public LeftPanelMenuForm(){
        super(By.xpath("//div[@class='left-pannel']"), "elementsPage");
    }

    public void expandAccordionElements() { buttonLeftPanelElements.click(); }
    public void clickButtonAlerts() {
        buttonAlerts.click();
    }
    public void clickButtonNestedFrames() {
        BrowserUtils.scrollToElement(buttonNestedFrames.getLocator(), buttonNestedFrames.getElementName());
        buttonNestedFrames.click();
    }
    public void clickButtonFrames() {
        buttonFrames.click();
    }
    public void clickButtonWebTables() {
        buttonWebTables.click();
    }
    public void clickButtonBrowserWindows() { buttonBrowserWindows.click(); }
    public void clickButtonLinks() { buttonLinks.click(); }
}
