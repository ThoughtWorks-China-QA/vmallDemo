package com.thoughtworks.gauge.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListPage extends BasePage {
    public WebElement q_product;

    public void chooseProduct(WebDriver driver, String productName) {
        String css =  ".p-name a[title=\""+productName+"\"]";
        q_product = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(css))));
        q_product.click();
    }
}
