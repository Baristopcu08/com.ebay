package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        return getDriver(Browsers.Chrome);
    }

    public static WebDriver getDriver(Browsers browsers){
        if (driver==null){
            switch (browsers){
                case Edge:
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
                case Frefox:
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options2=new FirefoxOptions();
                    //options2.addPreference("security.insecure_field_warning.contextual.enabled", false);
                    //options2.addArguments("user-data-dir=C:\\Users\\user\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\v41p3oc0.default-release");
                    driver=new FirefoxDriver(options2);
                    break;
                case Safari:
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case Chrome:
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
                    //options.addArguments("user-data-dir=C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data"); //login korumalı sayfada login olmak için
                    //options.addArguments("--headless");      //Crome arka planda çalışır
                    driver = new ChromeDriver(options);
                    break;
            }
        }
        return driver;
    }

    public static void quitDriver(){

        if (driver!=null) {
            driver.quit();
        }

    }
}
