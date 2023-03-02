import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseClass {
    String URL="https://www.ebay.co.uk/";
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BaseClass() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofMillis(10_000));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1_000));
        driver.manage().window().maximize();
        actions=new Actions(driver);

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

            while (oem != null ) {
                oem = reader.readLine();
                oemler.add(oem);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return oemler;
    }
}
