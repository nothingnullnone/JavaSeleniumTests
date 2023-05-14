package org.task3_1.pageObjects;

import org.openqa.selenium.By;
import org.task3_1.baseClasses.BaseForm;

public class QADemoSamplePage extends BaseForm {
    public QADemoSamplePage() {
        super(By.xpath("//*[@id='sampleHeading']"), "samplePage");
    }
}
