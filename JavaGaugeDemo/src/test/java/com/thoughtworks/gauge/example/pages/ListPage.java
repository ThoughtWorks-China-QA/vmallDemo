package com.thoughtworks.gauge.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListPage extends BasePage {
    public WebElement q_product;

    public void chooseProduct(WebDriver driver, String productName) {
        String css =  ".p-name a[title=\""+productName+"\"]";
        q_product = driver.findElement(By.cssSelector(css));
        q_product.click();
    }
}
