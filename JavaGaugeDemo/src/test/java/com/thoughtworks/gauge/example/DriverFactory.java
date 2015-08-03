package com.thoughtworks.gauge.example;

import com.thoughtworks.gauge.AfterStep;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static final String CHROME = "chrome";
    private static final Integer waitSeconds = 3;

    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver driver;

    @BeforeSuite
    public void Setup() {
        String browser = System.getenv("browser.name");
        if (browser.toLowerCase().equals(CHROME)) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
    }

    @AfterSuite
    public void TearDown() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
            driver.close();
        }
    }

    @BeforeStep
    public void WaitBeforeStepToMakeProcessSlow() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterStep
    public void WaitAfterStepToMakeProcessSlow() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }



}
