package com.testframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver getChromeDriver(){
        //Arrange
        //Set a system property to locate where the driver executable is
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        //Create an options object and set things to full screen
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        //Create Selenium Webdriver and pass in the option just created
        WebDriver driver = new ChromeDriver(options);
        //Add an implicit wait for a few sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}
