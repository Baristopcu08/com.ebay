package Login;

import Utils.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Login {


    WebDriver driver;

    @Test
    public void before() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");                //ilk açılışta maximize açılır
        //options.addArguments("--disable-notifications");       //# bildirimleri kapat
        //options.addArguments("--disable-extensions");            //# eklentileri kapat
        //options.addArguments("--disable-infobars");             //# bilgi çubuğunu kapat
        //options.addArguments("--disable-popup-blocking");       //# popup'ları engelle
        //options.addArguments("--disable-logging");              //# loglamayı kapat
        //options.addArguments("--disable-plugins-discovery");    //# eklenti keşfini engelle
        //options.addArguments("--disable-save-password-bubble"); //# şifre kaydetme istemini kapat
        //options.addArguments("--disable-translate");            //# çeviri özelliğini kapat
        // options.addArguments("--disable-web-security");         //# güvenlik önlemlerini kapat
        //options.addArguments("--ignore-certificate-errors");    //# sertifika hatalarını yoksay
        //options.addArguments("user-data");
        //options.addArguments("user-data-dir=" + System.getProperty("user.home") + "\\AppData\\Local\\Google\\Chrome\\User Data"); //login korumalı sayfada login olmak için
        options.addArguments("user-data-dir=C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data"); //login korumalı sayfada login olmak için
        //options.addArguments("--headless");      //Crome arka planda çalışır
        driver = new ChromeDriver(options);
        driver.get("https://accounts.google.com/login?hl=tr");
    }


}
