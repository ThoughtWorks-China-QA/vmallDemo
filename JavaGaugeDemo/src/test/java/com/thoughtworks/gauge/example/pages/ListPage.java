package com.thoughtworks.gauge.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ListPage extends BasePage {
    public static String NewProductUrl = Url.concat("list-56/");

    public WebElement q_product;

    public void chooseProduct(String productName) {
        String productCSS = ".pro-panels .p-name a[title=".concat(productName).concat("\"]\"");
        System.out.println("productCSS  " + productCSS);
        q_product.findElement(By.cssSelector(productCSS));
        q_product.click();
    }
}
