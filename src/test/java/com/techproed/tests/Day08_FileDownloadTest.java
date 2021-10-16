package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileDownloadTest extends TestBase {

    /*
      Create a class:FileDownloadTest
downloadTest()
In the downloadTest() method, do the following test:
Go to https://the-internet.herokuapp.com/download
Download flower.png file
Then verify if the file downloaded successfully
     */
    @Test
    public void fileDownloadTest() throws InterruptedException {
//        Create a class:FileDownloadTest
//        fileDownloadTest()
//        Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
//        Download flower.png file
        driver.findElement(By.linkText("flower.jpeg")).click();
//        Then verify if the file downloaded successfully
        //We must put hard wait dince file download takes a little bit time
        //Implicit or explicit wait cannot fix the problem, because download folder is windows based application
        Thread.sleep(5000);
        //Getting the PATH of the HOME directory with JAVA
        String pathOfFLower ="C:\\Users\\46764\\Downloads\\flower.jpeg";
        boolean isDownloaded = Files.exists(Paths.get(pathOfFLower));
        //Asserting if file download is succesful
        Assert.assertTrue(isDownloaded);

    }

}
