package turkish;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C01_Test2 {

    public static void main(String[] args) {

        /*
          1."http://zero.webappsecurity.com"
          2.Signin butonuna tiklayin
          3.Login alanina "username" yazdirin
          4.Pasword alanina "password" yazdirin
          5.Sign in butonuna tiklayin
          6.Online Banking butonuna tiklayin
          7.Pay Bills sayfasina gidin
          8.amount kismina yatirmak istediginiz herhangi bir miktari girin
          9.tarih kismina "2020-09-10" yazdirin
          10.Pay butonuna tiklayin
          11.The payment was successfully submitted. mesajinin ciktigini kontrol edin
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com");

        driver.findElement(By.xpath("//i[@class='icon-signin']")).click();

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");


        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");


        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.get("http://zero.webappsecurity.com");// kod ilerlemedigi icin rotayi tekrar yazdik

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();

        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        driver.findElement(By.id("sp_amount")).sendKeys("1000");

        driver.findElement(By.id("sp_date")).sendKeys("2020.09.10");

        driver.findElement(By.id("pay_saved_payees")).click();

        WebElement printTitle = driver.findElement(By.id("alert_content"));
        if (printTitle.isDisplayed()){
            System.out.println("test pass");
        }else{
            System.out.println("test failed");
        }

        driver.close();











    }

















}
