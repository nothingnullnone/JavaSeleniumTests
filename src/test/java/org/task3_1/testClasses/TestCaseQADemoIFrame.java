package org.task3_1.testClasses;

import org.openqa.selenium.WebDriver;
import org.task3_1.pageObjects.*;
import org.task3_1.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseQADemoIFrame extends BaseTest {
    @Test
    public void IFramesTest() {
        LogUtils.logInfo("Starting Test Case 2 - IFrame");
        WebDriver driver = WebDriverUtils.getDriver();
        String urlMain = (String) FileReadUtils.getField(Filenames.configFile, "url_main");
        LogUtils.logInfo("Step 1: Navigating to the Main page");
        driver.navigate().to(urlMain);
        var mainPage = new QADemoMainPage();
        Assert.assertTrue(mainPage.isFormPresent(), "Main page didn't open!");
        LogUtils.logInfo("Step 2: Clicking 'Alerts, Frame & Windows' button. In a menu clicking 'Nested frames' button");
        mainPage.clickButtonAlertsFrameWindows();
        var leftPanelMenu = new LeftPanelMenuForm();
        var nestedFramesForm = new NestedFramesForm();
        leftPanelMenu.clickButtonNestedFrames();
        Assert.assertTrue(nestedFramesForm.isFormPresent(), "The Nested frames form didn't open!");
        var parentFrameLocator = nestedFramesForm.getParentFrameForm().getLocator();
        var parentFrameName = nestedFramesForm.getParentFrameForm().getFormName();
        BrowserUtils.switchToFrame(parentFrameLocator, parentFrameName);
        Assert.assertEquals(nestedFramesForm.getParentFrameForm().getTextFromLabel(), "Parent frame","The message Parent frame didn't display!");
        var childFrameLocator = nestedFramesForm.getChildFrameForm().getLocator();
        var childFrameName = nestedFramesForm.getChildFrameForm().getFormName();
        BrowserUtils.switchToFrame(childFrameLocator, childFrameName);
        Assert.assertEquals(nestedFramesForm.getChildFrameForm().getTextFromLabel(), "Child Iframe","The message Child IFrame didn't display!");
        BrowserUtils.switchToDefaultContent();
        LogUtils.logInfo("Step 3: Selecting 'Frames' option in a left menu");
        leftPanelMenu.clickButtonFrames();
        var framesForm = new FramesForm();
        Assert.assertTrue(framesForm.isFormPresent(), "The Frames form didn't open!");
        var upperFrameLocator = framesForm.getUpperFrameForm().getLocator();
        var upperFrameName = framesForm.getUpperFrameForm().getFormName();
        BrowserUtils.switchToFrame(upperFrameLocator, upperFrameName);
        var textUpperFrame = framesForm.getUpperFrameForm().getTextFromLabel();
        BrowserUtils.switchToDefaultContent();
        var lowerFrameLocator = framesForm.getLowerFrameForm().getLocator();
        var lowerFrameName = framesForm.getLowerFrameForm().getFormName();
        BrowserUtils.switchToFrame(lowerFrameLocator, lowerFrameName);
        var textLowerFrame = framesForm.getLowerFrameForm().getTextFromLabel();
        BrowserUtils.switchToDefaultContent();
        Assert.assertEquals(textLowerFrame, textUpperFrame, "The message in the upper frame wasn't the same as the message in the lower frame");
    }
}
