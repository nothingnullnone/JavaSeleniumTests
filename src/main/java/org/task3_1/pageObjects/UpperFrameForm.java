package org.task3_1.pageObjects;

import org.openqa.selenium.By;
import org.task3_1.baseClasses.BaseForm;
import org.task3_1.webElements.Label;

public class UpperFrameForm extends BaseForm {
    private final Label labelUpperFrame = new Label(By.xpath("//*[@id='sampleHeading']"), "labelUpperFrame");

    UpperFrameForm() {
        super(By.xpath("//iframe[@id='frame1']"), "upperFrameForm");
    }

    public String getTextFromLabel() {
        return labelUpperFrame.getText();
    }
}
