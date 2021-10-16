package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileExistTest{

    /*
         Class: FileExistTest
Method: isExist
Pick a file on your desktop
And verify if that file exist on your computer or not
     */

    @Test
    public void isExist(){
        /*
        Selenium has limitation with desktop application
        * With Java we can check if a file exist in our local computer
        * */
        //Getting the PATH of the HOME directory with JAVA
        String homePath = System.getProperty("user.home");// /Users/techproed/Desktop/flower.jpeg
        String pathOfFLower ="C:\\Users\\46764\\OneDrive\\Desktop\\flower.jpeg";
        //WINDOW PATH
//        String pathOfFLower = homePath+"\\Desktop\\flower.jpeg";
        System.out.println(pathOfFLower);
        //This code checks if pathOfFlower is exist or not.
        //If it exist, this returns true; otherwise, this returns false
        boolean isExist  = Files.exists(Paths.get(pathOfFLower));
        Assert.assertTrue(isExist);
    }
}
