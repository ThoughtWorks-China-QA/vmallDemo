package com.thoughtworks.gauge.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
    public static String CustomerUrl = Url.concat("");

//    @FindBy(how = How.CSS, css = ".category-list  .category-item  .category-info  span:contains('移动电源')")
//    @FindBy(how = How.XPATH, xpath = "//div[@class=\"category-info\"]//span[contains(.,\"移动电源\")]")  //worked

    //worked
    //$x("//ol[@class=\"category-list\"]/*[@class=\"category-item\"]")
    ////span[contains(.,\"路由器\")]
    ////div[@class=\"category-info\"]//span[contains(.,\"路由器\")]
    @FindBy(how = How.CSS, css = ".category-list  .category-item  .category-info  span:contains('移动电源')")
    public WebElement q_powerBankCategory;

    public void chooseCategory(String catetory) {
//        String powerBankCategoryCSS = ".category-list .category-item .category-info span:contains(\'".concat(catetory).concat("\')");
//        System.out.println("powerBankCategoryCSS  " + powerBankCategoryCSS);
//        q_powerBankCategory.findElement(By.cssSelector());
//        q_powerBankCategory.findElement(By.linkText("移动电源"));
//        q_powerBankCategory.findElement(By.cssSelector(powerBankCategoryCSS));  span:contains("移动电源")

        q_powerBankCategory.click();
    }

}
