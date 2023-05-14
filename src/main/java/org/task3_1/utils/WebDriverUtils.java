package org.task3_1.utils;

import org.openqa.selenium.WebDriver;

public class WebDriverUtils {
    private static WebDriver driver;
    private static final String browser = (String) FileReadUtils.getField(Filenames.configFile, "browser");
    private static final String options = (String) FileReadUtils.getField(Filenames.configFile,"options");

    public static WebDriver getDriver() {
        if (driver == null) {
            LogUtils.logInfo(browser + " is initializing with options " + options + "!");
            try {
                driver = BrowserFactory.initDriver(browser, options);
            }
            catch (Exception e) {
                LogUtils.logError("Driver initialization error!", e);
            }
        }
        return driver;
    }

    public static void destroyDriver() {
        if (driver != null) {
            LogUtils.logInfo("Destroying driver!");
            driver.quit();
            driver = null;
        }
    }
}
