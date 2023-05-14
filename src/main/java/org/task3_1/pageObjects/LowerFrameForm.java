package org.task3_1.pageObjects;

import org.task3_1.baseClasses.BaseForm;
import org.task3_1.webElements.Label;
import org.openqa.selenium.By;

public class LowerFrameForm extends BaseForm {
    private final Label labelLowerFrame = new Label(By.xpath("//*[@id='sampleHeading']"), "labelLowerFrame");

    LowerFrameForm() {
        super(By.xpath("//iframe[@id='frame2']"), "lowerFrameForm");
    }

    public String getTextFromLabel() {
        return labelLowerFrame.getText();
    }
}
