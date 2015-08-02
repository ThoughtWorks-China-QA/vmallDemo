package com.thoughtworks.gauge.example;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.example.pages.HomePage;
import com.thoughtworks.gauge.example.pages.ListPage;
import com.thoughtworks.gauge.example.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddPowerBankSpec {
    private final WebDriver driver;

    public AddPowerBankSpec() {
        this.driver = DriverFactory.getDriver();
    }

    @Step("进入华为商城官网首页")
    public void navigateToHomePage() {
        driver.get(HomePage.CustomerUrl);
    }

    @Step("选择分类<移动电源>")
    public void chooseCategory(String catetory) {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.chooseCategory(driver, catetory);
    }

    @Step("选择产品<华为HUAWEI  Colorphon 5 超薄移动电源AP006 4800mAh  荣耀标准版（石墨黑）>")
    public void chooseProduct(String productName) {
        ListPage listPage = PageFactory.initElements(driver, ListPage.class);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        listPage.chooseProduct(driver, productName);
    }


    @Step("选择颜色为<苹果绿 华为版>,修改数量为<2>,并添加到购物车")
    public void purchaseProduct(String colorType, int count) {
        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        productPage.chooseColor(driver, colorType);
        productPage.setCount(driver, count);
        productPage.addToShopcart(driver);
    }

    @Step("能看到<成功加入购物车>字样")
    public void verifyPageContainsText(String text) {
        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
        productPage.verifyPageContainsText(driver,text);


    }


}
