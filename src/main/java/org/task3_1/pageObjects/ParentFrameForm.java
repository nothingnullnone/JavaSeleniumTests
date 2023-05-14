package org.task3_1.pageObjects;

import org.openqa.selenium.By;
import org.task3_1.baseClasses.BaseForm;
import org.task3_1.webElements.Label;

public class ParentFrameForm extends BaseForm {
    private final Label labelParentFrame = new Label(By.xpath("//body[contains(text(), 'Parent frame')]"), "labelParentFrame");
    ParentFrameForm() {
        super(By.xpath("//iframe[@id='frame1']"), "parentFrameForm");
    }

    public String getTextFromLabel() {
        return labelParentFrame.getText();
    }
}
