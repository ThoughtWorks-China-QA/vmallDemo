package com.thoughtworks.gauge.example;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PurchaseSingleProductSpec {
    private final WebDriver driver;
    private HomePage homePage;
    private ListPage listPage;
    private ProductPage productPage;
    private ShopcartPage shopcartPage;
    private LoginPage loginPage;

    public PurchaseSingleProductSpec() {
        this.driver = DriverFactory.getDriver();
    }

    @Step("进入华为商城官网首页")
    public void navigateToHomePage() {
        driver.get(HomePage.CustomerUrl);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Step("进入产品列表页")
    public void navigateToProductList() {
        listPage = PageFactory.initElements(driver, ListPage.class);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    @Step("进入产品详情页面")
    public void navigateToProductDetailPage() {
        productPage = PageFactory.initElements(driver, ProductPage.class);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

    }

    @Step("选择分类<移动电源>")
    public void chooseCategory(String catetory) {
        homePage.chooseCategory(driver, catetory);
    }

    @Step("选择产品<华为HUAWEI  Colorphon 5 超薄移动电源AP006 4800mAh  荣耀标准版（石墨黑）>")
    public void chooseProduct(String productName) {
        listPage.chooseProduct(driver, productName);
    }

    @Step("选择制式为<电信4G>")
    public void chooseModel(String model) {
        productPage.chooseModel(driver, model);
    }

    @Step("选择颜色为<苹果绿 华为版>")
    public void chooseColor(String colorType) {
        productPage.chooseColor(driver, colorType);
    }

    @Step("设定购买数量为<2>")
    public void setCount(int count) {
        productPage.setCount(driver, count);
    }

    @Step("添加到购物车")
    public void addToShopcart() {
        productPage.addToShopcart(driver);
    }

    @Step("能看到<成功加入购物车>字样")
    public void verifyPageContainsText(String text) {
        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
        productPage.verifyPageContainsText(driver, text);
    }

    @Step("购买产品<table>")
    public void purchaseProducts(Table table) {
        List<List<String>> rows = table.getRows();
        for (List<String> row : rows) {
            navigateToHomePage();
            chooseCategory(row.get(0));
            navigateToProductList();
            chooseProduct(row.get(1));
            navigateToProductDetailPage();
            if(!"null".equalsIgnoreCase(row.get(2)) ) {
                chooseModel(row.get(2));
            }
            chooseColor(row.get(3));
            setCount(Integer.parseInt(row.get(4)));
            addToShopcart();
        }
    }
    @Step("转到购物车页面")
    public void navigateToShopcartPage(){
        productPage.navigateToPaymentPage(driver);
        shopcartPage = PageFactory.initElements(driver, ShopcartPage.class);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    @Step("此时购物车内可以看到刚才购买的产品<table>")
    public void verifyProducts(Table table){
        List<List<String>> rows = table.getRows();
        for (List<String> row : rows) {
            shopcartPage.verifyProductName(driver, row.get(1));
        }
    }

    @Step("确认结算")
    public void navigateToPayment(){
        shopcartPage.navigateToPayment(driver);
    }

    @Step("验证进入登陆页面")
    public void navigateToLogin(){
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        loginPage.verifyOnLoginPaga(driver);
    }



    public void waitForSometime(Integer seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
