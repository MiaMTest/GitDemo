package com.framework;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyFirstUITestRefacotred {

    public static final String BASE_URL = "https://github.com/";
    static WebDriver driver;

    @BeforeAll
    static void setup() {
        //Arrange
        //Set a system property to locate where the driver executable is
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        //Create an options object and set things to full screen
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        //Create Selenium Webdriver and pass in the option just created

        driver = new ChromeDriver(options);
        //Add an implicit wait for a few sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
    static void cleanUp() {
        driver.close();
    }

    @Test
    void userNameIsCorrectOnOverviewTab() {

        //Define a user string variable
        String user = "andrejs-ps";
        //Use the driver object to driver the actions
        driver.get(BASE_URL + user);

        //Act
        //use the driver to find the element by object and save it in a variable
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();

        //Assert
        //Assert user matches the text we extracted from the element
        assertEquals(user, actualUserName);

    }

    @Test
    void repoLinkGoesToCorrectRepo() {

        String user = "andrejs-ps";
        driver.get(BASE_URL + user);

        //Act
        //(1)driver.findElement for repository with particular name; (2)parse linktext in;
        // (3)Store the found Web-element and call it repolink
        String repo = "Java-9-onwards";
        WebElement repoLink = driver.findElement(By.linkText(repo));
        repoLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actualURL = driver.getCurrentUrl();

        //Assert
        assertEquals("https://github.com/andrejs-ps/" + repo, actualURL);

      }


    @Test
    void repositoryCountIsCorrect() {
        //Act
        driver.get(BASE_URL + "/andrejs-ps/" +"?tab=repositories");

        List<WebElement> repos = driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));

        //Assert
       assertEquals(24,repos.size());
    }
}

