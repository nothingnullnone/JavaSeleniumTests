package org.task3_1.testClasses;

import org.task3_1.utils.LogUtils;
import org.task3_1.utils.WebDriverUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    @BeforeTest
    public void Setup(){
        try {
            WebDriverUtils.getDriver();
        } catch (Exception e) {
            LogUtils.logError("Error driver initializing", e);
        }
    }

    @AfterTest
    public void Cleanup(){
        WebDriverUtils.destroyDriver();
    }

}
