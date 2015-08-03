package com.thoughtworks.gauge.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public static String CustomerUrl = Url.concat("");

    public WebElement q_powerBankCategory ;

    public void chooseCategory(WebDriver driver, String category) {
        q_powerBankCategory = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated((By.linkText(category))));
        q_powerBankCategory.click();
    }

}
