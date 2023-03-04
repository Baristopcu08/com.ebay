import Utils.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseClass {
    String URL;
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    Select select;

    public BaseClass() {

        driver = Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofMillis(15_000));
        driver.manage().window().maximize();
        actions=new Actions(driver);
        URL="https://www.ebay.co.uk/";

    }

    void click(By locator){
        click(driver.findElement(locator));
    }

    void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    WebElement findElement(By locator){
        return  driver.findElement(locator);
    }
    List<WebElement> findElements(By locator){

        return  driver.findElements(locator);
    }

    void actions(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.scrollToElement(element).build().perform();

    }



    static List<String> getOem() {
        BufferedReader reader;
        String oem="";
        List<String> oemler=new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader("src/test/java/oemlist.txt"));
            oemler = reader.lines().toList();
            reader.close();
        } catch (IOException e) {
            e.getMessage();
        }
        return oemler;
    }

}
