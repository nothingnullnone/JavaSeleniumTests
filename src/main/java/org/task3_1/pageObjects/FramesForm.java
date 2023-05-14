package org.task3_1.pageObjects;

import org.openqa.selenium.By;
import org.task3_1.baseClasses.BaseForm;

public class FramesForm extends BaseForm {
    private final UpperFrameForm upperFrameForm = new UpperFrameForm();
    private final LowerFrameForm lowerFrameForm = new LowerFrameForm();

    public FramesForm() {
        super(By.xpath("//iframe[@src='/sample' and @id='frame2']"), "FramesForm");
    }

    public UpperFrameForm getUpperFrameForm() {
        return upperFrameForm;
    }

    public LowerFrameForm getLowerFrameForm() {
        return lowerFrameForm;
    }
}