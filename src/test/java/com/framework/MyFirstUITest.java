package com.framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class MyFirstUITest {


    @Test
    void userNameIsCorrectOnOverviewTab() {

        //Arrange
        //Set a system property to locate where the driver executable is
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        //Create an options object and set things to full screen
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        //Create Selenium Webdriver and pass in the option just created
        WebDriver driver = new ChromeDriver(options);
        //Add an implicit wait for a few sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Define a user string variable
        String user = "andrejs-ps";
        //Use the driver object to driver the actions
        driver.get("https://github.com/" + user);

        //Act
        //use the driver to find the element by object and save it in a variable
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();

        //Assert
        //Assert user matches the text we extracted from the element
        Assertions.assertEquals(user, actualUserName);

        //invoke driver.close
        driver.close();
    }

    @Test
    void repoLinkGoesToCorrectRepo() {
        //Arrange
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String user = "andrejs-ps";
        driver.get("https://github.com/" + user);

        //Act
        //(1)driver.findElement for repository with particular name; (2)parse linktext in;
        // (3)Store the found Web-element and call it repolink
        String repo = "Java-9-onwards";
        WebElement repolink = driver.findElement(By.linkText(repo));

        repolink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String actualURL = driver.getCurrentUrl();

        //Assert
        Assertions.assertEquals("https://github.com/andrejs-ps/" + repo, actualURL);

        driver.close();
    }


    @Test
    void countRepoNb() {
        //Arrange
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Act
        driver.get("https://github.com/andrejs-ps?tab=repositories");

        List<WebElement> repos = driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));

        //Assert
        Assertions.assertEquals(24,repos.size());
        driver.close();


    }
    @Test
    public void testUI2(){
        System.out.println("test added for Git demo purpose");
    }
}

