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

    @Step("选择分类 <移动电源>")
    public void chooseCategory(String catetory) {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.chooseCategory(catetory);
    }

    @Step("选择产品 <华为HUAWEI  Colorphon 5 超薄移动电源AP006 4800mAh  荣耀标准版（石墨黑）>")
    public void chooseProduct(String productName) {
        ListPage listPage = PageFactory.initElements(driver, ListPage.class);
        listPage.chooseProduct(productName);
    }

    @Step("选择颜色为 <苹果绿 华为版>")
    public void chooseColor(String colorType) {
        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
        productPage.chooseColor(colorType);
    }
}
