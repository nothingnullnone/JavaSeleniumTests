package org.task3_1.testClasses;

import org.openqa.selenium.WebDriver;
import org.task3_1.dataModels.UserInfo;
import org.task3_1.pageObjects.*;
import org.task3_1.utils.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.*;

public class TestCaseQADemoTables extends BaseTest {
    @DataProvider(name = "tables")
    public Object[][] getData() {
        try {
            var users = (List<HashMap<String, String>>) FileReadUtils.getField(Filenames.testDataFileTables, "users");
            Object[][] data = new Object[users.size()][1];
            for (int i = 0; i < users.size(); i++) {
                data[i][0] = users.get(i);
            }
            return data;
        }
        catch (Exception e) {
            LogUtils.logError("Error reading users' data from the test data file!", e);
            return new Object[][] {{}};
        }
    }

    @Test(dataProvider = "tables")
    public void TablesTest(HashMap<String, String> userMap) {
        LogUtils.logInfo("Starting Test Case 3 - Tables");
        WebDriver driver = WebDriverUtils.getDriver();
        String urlMain = (String) FileReadUtils.getField(Filenames.configFile,"url_main");
        LogUtils.logInfo("Step 1: Navigating to the Main page");
        driver.navigate().to(urlMain);
        var mainPage = new QADemoMainPage();
        Assert.assertTrue(mainPage.isFormPresent(), "Main page didn't open!");
        LogUtils.logInfo("Step 2: Clicking 'Elements' button. In the menu clicking 'Web tables' button");
        mainPage.clickButtonElements();
        var leftPanelMenuForm = new LeftPanelMenuForm();
        leftPanelMenuForm.clickButtonWebTables();
        var webTablesForm = new WebTablesForm();
        Assert.assertTrue(webTablesForm.isFormPresent(), "The Tables form didn't open!");
        LogUtils.logInfo("Step 3: Clicking 'Add' button");
        webTablesForm.clickButtonAdd();
        var registrationForm = new RegistrationForm();
        Assert.assertTrue(registrationForm.isFormPresent(), "The Registration form didn't open!");
        LogUtils.logInfo("Step 4: Entering data for user from the table and clicking 'Submit' button");
        registrationForm.registerUser(userMap);
        var user = new UserInfo(userMap);
        Assert.assertTrue(registrationForm.isFormInvisible(), "The Registration form didn't close!");
        List<UserInfo> users = webTablesForm.getUsers();
        Assert.assertTrue(users.contains(user), "The new user's data didn't appear in the table");
        var usersCountBeforeDeleting = webTablesForm.getUsersCount();
        LogUtils.logInfo("Step 5: Clicking 'Delete' button in a row which contains data of the added user");
        webTablesForm.deleteUser(user);
        var usersCountAfterDeleting = webTablesForm.getUsersCount();
        Assert.assertNotEquals(usersCountBeforeDeleting, usersCountAfterDeleting, "Number of records in table didn't change");
        users = webTablesForm.getUsers();
        Assert.assertFalse(users.contains(user), "The new user's data wasn't deleted from the table");
    }
}
