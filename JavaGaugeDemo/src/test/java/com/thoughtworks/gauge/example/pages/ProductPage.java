package com.thoughtworks.gauge.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends BasePage{
    public static String ProductsUrl = Url.concat("1937.html");
    
    public WebElement q_title;
    
    public WebElement q_submit;

    @FindBy(how = How.CSS, css = "#main_content table tbody tr:nth-child(1) td.product a")
    public WebElement firstProduct;
    
    public void chooseColor(String color) {
        q_title.sendKeys(color);
        q_submit.click();
    }

    public void openFirstProduct() {
        firstProduct.click();
    }
}
