package com.framework.uitests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OverviewTabtests extends BaseTestClass{
    //Define a user string variable
    String user = "andrejs-ps";

    @BeforeEach
    void overviewTabSetup(){
        //Use the driver object to driver the actions
        //open the browser at a specific URL
        driver.get(BASE_URL + user);
    }
    @AfterEach
    void localcleanup(){
        //nothing to do here now, but maybe in the future?
    }

    @Test
    void userNameIsCorrectOnOverviewTab() {

        //Act
        //use the driver to find the element by object and save it in a variable
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();

        //Assert
        //Assert user matches the text we extracted from the element
        assertEquals(user, actualUserName);

    }
    @Test
    void repoLinkGoesToCorrectRepo() {

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
}
