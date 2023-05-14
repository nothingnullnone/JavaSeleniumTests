package org.task3_1.pageObjects;

import org.openqa.selenium.By;
import org.task3_1.baseClasses.BaseForm;
import org.task3_1.webElements.Link;

public class LinksForm extends BaseForm {
    private final Link linkHome = new Link(By.xpath("//a[@id='simpleLink']"), "linkHome");

    public LinksForm() {
        super(By.xpath("//div[@id='linkWrapper']"), "linksForm");
    }

    public void clickLinkHome() {
        linkHome.click();
    }
}
