package org.task3_1.testClasses;

import org.openqa.selenium.WebDriver;
import org.task3_1.pageObjects.*;
import org.task3_1.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseQADemoWindows extends BaseTest {

    @Test
    public void WindowsTest() {
        WebDriver driver = WebDriverUtils.getDriver();
        LogUtils.logInfo("Starting Test Case 4 - Handles");
        String urlMain = (String) FileReadUtils.getField(Filenames.configFile, "url_main");
        LogUtils.logInfo("Step 1: Navigating to the Main page");
        driver.navigate().to(urlMain);
        var mainPage = new QADemoMainPage();
        Assert.assertTrue(mainPage.isFormPresent(), "Main page didn't open!");
        LogUtils.logInfo("Step 2: Clicking 'Alerts, Frame & Windows' button. In a menu clicking 'Browser Windows' button");
        mainPage.clickButtonAlertsFrameWindows();
        var leftPanelMenuForm = new LeftPanelMenuForm();
        leftPanelMenuForm.clickButtonBrowserWindows();
        var browserWindowsForm = new BrowserWindowsForm();
        Assert.assertTrue(browserWindowsForm.isFormPresent(), "Browser windows form didn't open!");
        var initialTabHandle = BrowserUtils.getTabHandle();
        LogUtils.logInfo("Step 3: Clicking 'New Tab' button!");
        int openTabsCount = BrowserUtils.getTabsCount();
        browserWindowsForm.clickButtonNewTab();
        BrowserUtils.switchToNextTab(openTabsCount);
        var samplePage = new QADemoSamplePage();
        var samplePageTabHandle = BrowserUtils.getTabHandle();
        Assert.assertTrue(samplePage.isFormPresent(), "Sample page didn't open!");
        Assert.assertNotEquals(initialTabHandle, samplePageTabHandle, "A new tab didn't open");
        LogUtils.logInfo("Step 4: Closing current tab");
        BrowserUtils.closeTab();
        BrowserUtils.switchToTab(initialTabHandle);
        Assert.assertTrue(browserWindowsForm.isFormPresent(), "Browser windows form didn't open!");
        LogUtils.logInfo("Step 5: Clicking 'Elements'->'Links' button in the left menu");
        leftPanelMenuForm.expandAccordionElements();
        leftPanelMenuForm.clickButtonLinks();
        var linksForm = new LinksForm();
        Assert.assertTrue(linksForm.isFormPresent(), "Links form didn't open!");
        LogUtils.logInfo("Step 6: Clicking on 'Home' link");
        openTabsCount = BrowserUtils.getTabsCount();
        linksForm.clickLinkHome();
        BrowserUtils.switchToNextTab(openTabsCount);
        var newMainPageTabHandle = BrowserUtils.getTabHandle();
        Assert.assertTrue(mainPage.isFormPresent(), "Main page didn't open!");
        Assert.assertNotEquals(initialTabHandle, newMainPageTabHandle, "A new tab didn't open");
        LogUtils.logInfo("Step 7: Resuming to previous tab");
        BrowserUtils.switchToTab(initialTabHandle);
        Assert.assertTrue(linksForm.isFormVisible(), "Tab wasn't switched!");
    }
}