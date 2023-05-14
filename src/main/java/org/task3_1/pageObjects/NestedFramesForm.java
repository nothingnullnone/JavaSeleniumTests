package org.task3_1.pageObjects;

import org.openqa.selenium.By;
import org.task3_1.baseClasses.BaseForm;

public class NestedFramesForm extends BaseForm {
    private final ParentFrameForm parentFrameForm = new ParentFrameForm();
    private final ChildFrameForm childFrameForm = new ChildFrameForm();

    public NestedFramesForm(){
        super(By.xpath("//iframe[@src='/sampleiframe' and @id='frame1']"), "nestedFramesForm");
    }

    public ParentFrameForm getParentFrameForm() {
        return parentFrameForm;
    }

    public ChildFrameForm getChildFrameForm() {
        return childFrameForm;
    }
}
