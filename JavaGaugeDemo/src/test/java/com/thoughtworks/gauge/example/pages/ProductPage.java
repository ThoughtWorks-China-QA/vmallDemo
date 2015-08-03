package com.thoughtworks.gauge.example.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.hamcrest.Matchers.containsString;


public class ProductPage extends BasePage{
    @FindBy(how= How.CSS, css ="a[title='加']")
    public WebElement q_increase;

    @FindBy(how= How.CSS, css = "a.button-add-cart")
    public WebElement q_submit;

    public WebElement q_item;

    public WebElement q_text;

    @FindBy(how= How.CSS, css = "div.pro-add-success-button a[title='去购物车结算']")
    public WebElement q_toPay;

    public void chooseModel(WebDriver driver, String model){
        String css = ".right-area .sku a[title='"+model+"']";
        q_item = driver.findElement(By.cssSelector(css));
        q_item.click();
    }

    public void chooseColor(WebDriver driver, String color) {

        String css = ".right-area .sku a[title=\""+color+"\"]";
        q_item = driver.findElement(By.cssSelector(css));
        q_item.click();
    }

    public void setCount(WebDriver driver, int count){
        while(count>1){
            q_increase.click();
            count--;
        }
    }

    public void addToShopcart(WebDriver driver) {
        q_submit.click();
    }

    public void verifyPageContainsText(WebDriver driver, String text) {
        q_text = driver.findElement(By.xpath("//div[text()='"+text+"']"));
        Assert.assertThat(text + "不存在", q_text.getText(), containsString(text));
    }

    public void navigateToPaymentPage(WebDriver driver) {
        q_toPay.click();
    }
}
