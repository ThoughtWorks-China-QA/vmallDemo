package com.thoughtworks.gauge.example.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.Matchers.containsString;

public class LoginPage extends BasePage {
    public void verifyOnLoginPaga(WebDriver driver){
        String pageUrl = driver.getCurrentUrl();
        Assert.assertThat("未进入预期的登陆页面", pageUrl, containsString("login.jsp"));
    }
}
