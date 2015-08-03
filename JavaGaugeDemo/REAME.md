# Gaugue example project for Vmall, in Java
##Prerequisites
- [Install Gauge](http://getgauge.io/download.html)
  - Homebrew on Mac OS X :  
      ```
      brew install gauge
      ```
  - [Download Installer](http://getgauge.io/download.html)
- [Install Gauge-Java plugin](http://getgauge.io/documentation/user/current/plugins/installation.html) by running<br>
  ```
  gauge --install java
  ```
- Get the latest version of Selenium Server Standalone Jar, 2 ways are discussed below : 
  - [Selenium Jar](http://selenium-release.storage.googleapis.com/index.html) should be added as a dependency in the project under ```libs``` directory.
  - Use [Gradle](https://gradle.org/downloads) and run <br>
    ```
    gradle copyToLib
    ```
- [Chrome driver executable](https://sites.google.com/a/chromium.org/chromedriver/downloads) should be in ```PATH``` for executing against chrome browser.
- [Gauge Intellij plugin](https://plugins.jetbrains.com/plugin/7535) (optional, but recommended). More information on plugin can be found [here](http://getgauge.io/documentation/user/current/ide_support/intellij_idea.html)

##Executing specs

### Command line
#### All specs
````
gauge specs/
````
This will also compile all the supporting code implementations.

#### Run against chrome browser
[Chrome driver executable](https://sites.google.com/a/chromium.org/chromedriver/downloads) should be in ```PATH``` for executing.
- Command Line   
  ```
  gauge --env chrome specs/
  ```
- IDE 
  1. Go to `Edit Configurations` dialog.
  2. Enter 'chrome' to `Environment` text field.
  3. Save the configuration and run it.
  
###Improt to Intellij
- Run Command Line
```
gradle idea
```
- In Intellij, File -> Open -> Choose gauge-example-java/gauge-example-java.ipr

### 问题解决
- 使用IDE运行/debug测试后,使用gauge命令运行或者IDE运行测试,都无法运行,提示缺少包或者class文件.
解决方案: 删除项目目录下的out文件夹,然后再次运行

- 修改没步骤的wait时长
解决方案: 修改src/test/java/com/thoughtworks/gauge/example/DriverFactory.java的    
```
private static final Integer waitSeconds = 2;
```

- csv文件中为什么只有一行测试数据?
解决方案: 在调试过程中发现,当购买多个产品时,华为商城本身经常会抛出error,导致无法将产品加入购物车.这与测试行为无关,故将测试数据只改为一行.如果想尝试运行多条数据,可以继续添加例如:
```
手机,华为 荣耀畅玩4C 双卡双待 电信4G版智能手机（黑色）套餐版,电信4G,黑色,1
```

- 为什么运行products.spec老是失败?
解决方案: 在调试过程中发现,当购买多个产品时,华为商城本身经常会抛出error,导致无法将产品加入购物车.这与测试行为无关.可以删掉一行数据然后再运行测试

