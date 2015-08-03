package com.thoughtworks.gauge.example.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.Matchers.containsString;


public class ProductPage extends BasePage{
    @FindBy(how= How.CSS, css ="a[title='加']")
    public WebElement q_increase;

    public WebElement q_submit;

    public WebElement q_item;

    public WebElement q_text;

    public WebElement q_toPay;

    public void chooseModel(WebDriver driver, String model){
        String css = ".right-area .sku a[title='"+model+"']";
        q_item = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(css))));
        q_item.click();
    }

    public void chooseColor(WebDriver driver, String color) {
        String css = ".right-area .sku a[title=\""+color+"\"]";
        q_item = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(css))));
        q_item.click();
    }

    public void setCount(WebDriver driver, int count){
        while(count>1){
            q_increase.click();
            count--;
        }
    }

    public void addToShopcart(WebDriver driver) {
        String css = "a.button-add-cart";
        q_submit = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable((By.cssSelector(css))));
        q_submit.click();
//        WebElement dynamicWebElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pro-add-success-msg")));

    }

    public void verifyPageContainsText(WebDriver driver, String text) {
        q_text = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[text()='" + text + "']"))));
        Assert.assertThat(text + "不存在", q_text.getText(), containsString(text));
    }

    public void navigateToPaymentPage(WebDriver driver) {
        String css = "div.pro-add-success-button a[title='去购物车结算']";
        q_toPay = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(css))));
        q_toPay.click();
    }
}
