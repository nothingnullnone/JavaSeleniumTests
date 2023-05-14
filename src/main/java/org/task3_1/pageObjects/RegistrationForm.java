package org.task3_1.pageObjects;

import org.openqa.selenium.By;
import org.task3_1.baseClasses.BaseForm;
import org.task3_1.webElements.*;
import java.util.HashMap;

public class RegistrationForm extends BaseForm {
    private final TextBox textBoxFirstName = new TextBox(By.xpath("//input[@id='firstName']"), "textBoxFirstName");
    private final TextBox textBoxLastName = new TextBox(By.xpath("//input[@id='lastName']"), "textBoxLastName");
    private final TextBox textBoxEmail = new TextBox(By.xpath("//input[@id='userEmail']"), "textBoxEmail");
    private final TextBox textBoxAge = new TextBox(By.xpath("//input[@id='age']"), "textBoxAge");
    private final TextBox textBoxSalary = new TextBox(By.xpath("//input[@id='salary']"), "textBoxSalary");
    private final TextBox textBoxDepartment = new TextBox(By.xpath("//input[@id='department']"), "textBoxDepartment");
    private final Button buttonSubmit = new Button(By.xpath("//button[@id='submit']"), "buttonSubmit");

    public RegistrationForm() {
        super(By.xpath("//form[@id='userForm']"), "RegistrationForm");
    }

    public void enterTextInTextBoxFirstName(String text) {
        textBoxFirstName.enterText(text);
    }
    public void enterTextInTextBoxLastName(String text) {
        textBoxLastName.enterText(text);
    }
    public void enterTextInTextBoxEmail(String text) {
        textBoxEmail.enterText(text);
    }
    public void enterTextInTextBoxAge(String text) {
        textBoxAge.enterText(text);
    }
    public void enterTextBoxSalary(String text) {
        textBoxSalary.enterText(text);
    }
    public void enterTextBoxDepartment(String text) {
        textBoxDepartment.enterText(text);
    }
    public void clickButtonSubmit() { buttonSubmit.click(); }

    public void registerUser(HashMap<String, String> userMap) {
        enterTextInTextBoxFirstName(userMap.get("firstName"));
        enterTextInTextBoxLastName(userMap.get("lastName"));
        enterTextInTextBoxEmail(userMap.get("email"));
        enterTextInTextBoxAge(userMap.get("age"));
        enterTextBoxSalary(userMap.get("salary"));
        enterTextBoxDepartment(userMap.get("department"));
        clickButtonSubmit();
    }
}
