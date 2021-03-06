package com.techproed;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Day08_Actions4 extends TestBase {


    //NOW WE USED TESTBASE, WE DON'T USE BEFORE AND AFTER CLASS
//    WebDriver driver;
//    @Before
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//    }
    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com");

        Actions actions= new Actions(driver);

        /*
          PAGE_DOWN => scroll down the page
          ARROW_DOWN => scroll down thw page
         */
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(2000);
        //ARROW_DOWN scrolls the page down less than PAGE_DOWN
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        //PAGE_UP
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_UP).perform();

        //ARROW_UP moves the page up a little bit
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_UP).perform();
    }
//    @After
//    public void tearDown(){
//        driver.close();
//    }
}
