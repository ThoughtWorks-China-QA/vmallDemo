package com.thoughtworks.gauge.example.pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.Matchers.containsString;

public class ShopcartPage extends BasePage {
    public WebElement q_prouctName;
    public WebElement q_toPay;

    public void verifyProductName(WebDriver driver, String text) {
        q_prouctName = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("p.p-name a[title='" + text.replace(" ", "\u00a0") + "']"))));
        Assert.assertThat(text + "不存在", q_prouctName.getText(), containsString(text));
    }

    public void navigateToPayment(WebDriver driver) {
        String css = css = "a[seed='cart-pay']";
        q_toPay = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(css))));
        q_toPay.click();
    }
}
