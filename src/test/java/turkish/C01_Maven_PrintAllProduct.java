package turkish;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C01_Maven_PrintAllProduct {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        //a.amazon sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //b.arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Samsung headphones"+ Keys.ENTER);

        //c."Samsung headphones ile arama yapalim"
        WebElement samsungHeadphones = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        //By.className ile locate ettigimizde class attribute nin degerinde bosluk varsa locator calismayabilir

        //d.bulunan sonuc sayisini yazdiralim
        System.out.println(samsungHeadphones.getText());

        //e.ilk urunu tiklayalim
       // WebElement firstProduct = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
       // firstProduct.click();// sadece bir click yapacaksak web elementi olusturmaya ve assign etmeye gerek yoktur
                             //direk locate edip sonra click yapabilirsiniz
                             driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        driver.navigate().back();//bi sonraki stepte geri urunlerin tamamini yazdirabilmek icin geri donmem gerek

        //f.sayfadaki tum basliklari yazdiralim
        List<WebElement> printAllProduct = driver.findElements(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])"));
        for (WebElement each:printAllProduct) {
            System.out.println(each.getText());

        }



    }










}
