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
 