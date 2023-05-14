package org.task3_1.pageObjects;

import org.openqa.selenium.By;
import org.task3_1.baseClasses.BaseForm;
import org.task3_1.webElements.*;

public class AlertsForm extends BaseForm {
    private final Button buttonAlert = new Button(By.xpath("//button[@id='alertButton']"), "buttonAlert");
    private final Button buttonConfirm = new Button(By.xpath("//button[@id='confirmButton']"), "buttonConfirm");
    private final Button buttonPrompt = new Button(By.xpath("//button[@id='promtButton']"), "buttonPrompt");
    private final Label labelConfirmResult = new Label(By.xpath("//span[@id='confirmResult']"), "labelConfirmResult");
    private final Label labelPromptResult = new Label(By.xpath("//span[@id='promptResult']"), "labelPromptResult");

    public AlertsForm(){
        super(By.xpath("//div[@id='javascriptAlertsWrapper']"), "alertsForm");
    }

    public void clickButtonAlert() {
        buttonAlert.click();
    }

    public void clickButtonConfirm() {
        buttonConfirm.click();
    }

    public void clickButtonPrompt() {
        buttonPrompt.click();
    }

    public String getTextFromLabelConfirmResult() {
        return labelConfirmResult.getText();
    }

    public String getTextFromLabelPromptResult() {
        return labelPromptResult.getText();
    }
}
