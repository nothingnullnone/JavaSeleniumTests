package org.task3_1.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

    public static WebDriver initDriver(String browser, String options) throws Exception {
        switch (browser) {
            case "Chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                for (String option : options.split(", ")) {
                    chromeOptions.addArguments(option);
                    chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                }
                return new ChromeDriver(chromeOptions);
            }
            case "Firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                for (String option : options.split(", ")) {
                    firefoxOptions.addArguments(option);
                    firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                }
                return new FirefoxDriver(firefoxOptions);
            }
            case "Edge" -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                for (String option : options.split(", ")) {
                    edgeOptions.addArguments(option);
                    edgeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

                }
                return new EdgeDriver(edgeOptions);
            }
            default -> throw new Exception("Error browser initialization!");
        }
    }
}
