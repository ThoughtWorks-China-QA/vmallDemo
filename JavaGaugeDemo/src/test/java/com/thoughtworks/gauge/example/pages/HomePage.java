package com.thoughtworks.gauge.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public static String CustomerUrl = Url.concat("");

    public WebElement q_powerBankCategory;

    public void chooseCategory(WebDriver driver, String category) {
        q_powerBankCategory = driver.findElement(By.linkText(category));
        q_powerBankCategory.click();
    }

}
