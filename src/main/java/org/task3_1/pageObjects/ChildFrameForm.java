package org.task3_1.pageObjects;

import org.openqa.selenium.By;
import org.task3_1.baseClasses.BaseForm;
import org.task3_1.webElements.Label;

public class ChildFrameForm extends BaseForm {
    private final Label labelChildFrame = new Label(By.xpath("//p[contains(text(), 'Child Iframe')]"), "labelChildIframe");
    ChildFrameForm() {
        super(By.xpath("//iframe[contains(@srcdoc, 'Child')]"), "childFrameForm");
    }

    public String getTextFromLabel() {
        return labelChildFrame.getText();
    }
}
