package org.task3_1.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.task3_1.baseClasses.BaseForm;
import org.task3_1.dataModels.UserInfo;
import org.task3_1.webElements.*;
import org.task3_1.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;

public class WebTablesForm extends BaseForm {
    private final Button buttonAdd = new Button(By.xpath("//button[@id='addNewRecordButton']"), "buttonAdd");

    public WebTablesForm() {
        super(By.xpath("//div[@class='web-tables-wrapper']"), "WebTablesForm");
    }

    public void clickButtonAdd() {
        buttonAdd.click();
    }

    public List<UserInfo> getUsers() {
        List<UserInfo> users = new ArrayList<>();
        for (int i = 0; i < getTableSize(); i++){
            String[] row = getTableRow(i);
            if (row.length == UserInfo.class.getDeclaredFields().length) {
                UserInfo user = new UserInfo(row);
                users.add(user);
            }
            else break;
        }
        return users;
    }

    public int getUsersCount() {
        List<UserInfo> users = getUsers();
        return users.size();
    }

    public void deleteUser(UserInfo user) {
        try {
            List<UserInfo> users = getUsers();
            int indexToDelete = users.indexOf(user) + 1;
            LogUtils.logInfo("Deleting user " + user.toString());
            String deleteButtonsLocator = "//span[contains(@id, 'delete-record-";
            Button deleteButton = new Button(By.xpath(deleteButtonsLocator + indexToDelete + "')]"), "deleteButton" + indexToDelete);
            deleteButton.click();
        }
        catch (Exception e) {
            LogUtils.logError("Error deleting user!", e);
        }
    }

    private int getTableSize() {
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        return rows.size();
    }

    private String[] getTableRow(int num) {
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        return rows.get(num).getText().split("\n");
    }
}