package org.task3_1.testClasses;

import org.openqa.selenium.WebDriver;
import org.task3_1.pageObjects.*;
import org.task3_1.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseQADemoAlerts extends BaseTest {

    @Test
    public void AlertsTest() {
        LogUtils.logInfo("Starting Test Case 1 - Alerts");
        WebDriver driver = WebDriverUtils.getDriver();
        String urlMain = (String) FileReadUtils.getField(Filenames.configFile, "url_main");
        LogUtils.logInfo("Step 1: Navigating to the Main page");
        driver.navigate().to(urlMain);
        var mainPage = new QADemoMainPage();
        Assert.assertTrue(mainPage.isFormPresent(), "The Main page didn't open!");
        LogUtils.logInfo("Step 2: Clicking 'Alerts, Frame & Windows' button. In a menu clicking 'Alerts' button");
        mainPage.clickButtonAlertsFrameWindows();
        var leftPanelMenuForm = new LeftPanelMenuForm();
        leftPanelMenuForm.clickButtonAlerts();
        var alertsForm = new AlertsForm();
        Assert.assertTrue(alertsForm.isFormPresent(), "The Alerts form didn't open!");
        LogUtils.logInfo("Step 3: Clicking 'Click button to see alert' button");
        alertsForm.clickButtonAlert();
        String textAlertClicked = (String) FileReadUtils.getField(Filenames.testDataFileAlerts, "textAlertClicked");
        var alertClicked = AlertUtils.getAlert();
        Assert.assertEquals(AlertUtils.getAlertText(alertClicked), textAlertClicked, "Unexpected alert text!");
        LogUtils.logInfo("Step 4: Clicking 'OK' button");
        AlertUtils.acceptAlert(alertClicked);
        Assert.assertFalse(AlertUtils.isAlertPresent(), "An alert hasn't closed");
        LogUtils.logInfo("Step 5: Clicking 'On button click, confirm box will appear' button");
        alertsForm.clickButtonConfirm();
        var alertConfirm = AlertUtils.getAlert();
        String textAlertConfirm = (String) FileReadUtils.getField(Filenames.testDataFileAlerts, "textAlertConfirm");
        Assert.assertEquals(AlertUtils.getAlertText(alertConfirm), textAlertConfirm, "Unexpected alert text!");
        LogUtils.logInfo("Step 6: Clicking 'OK' button");
        AlertUtils.acceptAlert(alertConfirm);
        Assert.assertFalse(AlertUtils.isAlertPresent(), "An alert hasn't closed");
        String textLabelOK = (String) FileReadUtils.getField(Filenames.testDataFileAlerts,"textLabelOK");
        Assert.assertEquals(alertsForm.getTextFromLabelConfirmResult(), textLabelOK, "Unexpected confirm label text!");
        LogUtils.logInfo("Step 7: Clicking 'On button click, prompt box will appear' button");
        alertsForm.clickButtonPrompt();
        var alertPrompt = AlertUtils.getAlert();
        String textAlertPrompt = (String) FileReadUtils.getField(Filenames.testDataFileAlerts, "textAlertPrompt");
        Assert.assertEquals(AlertUtils.getAlertText(alertPrompt), textAlertPrompt, "Unexpected alert text!");
        var randomTextMinLength = ((Long) FileReadUtils.getField( Filenames.testDataFileAlerts, "textMinLength")).intValue();
        var randomTextMaxLength = ((Long) FileReadUtils.getField( Filenames.testDataFileAlerts, "textMaxLength")).intValue();
        String randomText = RandomUtils.getRandomString(randomTextMinLength, randomTextMaxLength);
        LogUtils.logInfo("Step 8: Entering randomly generated string, clicking 'OK' button");
        AlertUtils.setAlertInputText(alertPrompt, randomText);
        AlertUtils.acceptAlert(alertPrompt);
        Assert.assertFalse(AlertUtils.isAlertPresent(), "An alert hasn't closed");
        String textLabelEntered = (String) FileReadUtils.getField(Filenames.testDataFileAlerts, "textLabelEntered");
        Assert.assertEquals(alertsForm.getTextFromLabelPromptResult(), textLabelEntered + randomText, "Unexpected prompt label text!");
    }
}
