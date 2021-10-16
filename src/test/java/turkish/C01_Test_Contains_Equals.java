package turkish;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C01_Test_Contains_Equals {

    public static void main(String[] args) {

        /*
           //1.Go to that address https://walmart.com/
           //2.Browser i tam sayfa yapin
           //3. Sayfayi refresh yapin
           //4. Sayfa basliginin save ifadesi icerdigini kontrol edin
           //5.Sayfa basliginin "Walmart.com I Save Money.Live.Better" a esit oldugunu kontrol edin
           //6.URL nin walmart.com icerdigini kontrol edin
           //7. Nutella icin arama yapin
           //8.Kac sonuc buldugunuzu yazin
           //9.Sayfayi kapatin
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //1.Go to that address https://walmart.com/
        driver.get("https://walmart.com/");
        //2.Browser i tam sayfa yapin
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //3. Sayfayi refresh yapin
        driver.navigate().refresh();
        //4. Sayfa basliginin save ifadesi icerdigini kontrol edin
        String actualTitle = driver.getTitle();
        String searchWord = "Save";

        if (actualTitle.contains(searchWord)){
            System.out.println("tittle "+ searchWord + "kelimesini iceriyor"+ "test pass");
        }else{
            System.out.println("Failed");
        }

        //5.Sayfa basliginin "Walmart.com I Save Money.Live.Better" a esit oldugunu kontrol edin
        String expectedTitle = "Walmart.com I Save Money.Live.Better";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("That are equal, test pass");
        }else{
            System.out.println("That are not equal, test failed");
            System.out.println("actual title"+actualTitle);
        }
        //6.URL nin walmart.com icerdigini kontrol edin
        String actualURL = driver.getCurrentUrl();
        String searchUrl = "walmart.com";

        if (actualURL.contains(searchUrl)){
            System.out.println("URL"+ searchUrl +"kelimesini iceriyor,test pass");
        }else{
            System.out.println("URL"+ searchUrl +"kelimesini icermiyor,test failed");
            System.out.println(actualURL);
        }
        //7. Nutella icin arama yapin
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);
        //8.Kac sonuc buldugunuzu yazin
        WebElement resultNutella = driver.findElement(By.xpath("//div[@class='inline-flex mv3-xl mt3 ml3 ml4-xl mr1 db']"));
        System.out.println("nutella sayisi: "+ resultNutella);

        driver.close();






















    }
}
