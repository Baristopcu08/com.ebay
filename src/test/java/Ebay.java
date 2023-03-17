
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.*;
import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class Ebay extends BaseClass implements Locators{



    @Test
    public void FisrtTest() throws InterruptedException {

        List<String> oemler = getOem();
        List<String> finishList=new ArrayList<>();

        String oemBulunamadi="Bu Oemden liste yok";
        String OEM="emty";
        String title="emty";
        String saticiAdi="emty";
        String fiyat="emty";
        String sonSatis="emty";
        String fotoUrl="emty";
        String avaleble="emty";
        String sold="emty";
        String postage="emty";
        String itemNumber="emty";
        String oOemlerTex="emty";
        String sellerLocation="emty";

        driver.get("https://www.ebay.co.uk/");

        List<WebElement> allPruduct;
        selectDemoItems();

//        By lBanner=By.xpath("//div[@id='gdpr-banner']");
//        By lBunnerdeclineButton=By.xpath("//button[@id='gdpr-banner-decline']");
//
//        if (findElement(lBanner).isDisplayed()) {
//                click(lBunnerdeclineButton);
//        }

        selectBigMenu();
        selectCauntry();

        selectNearFirstList();
        selectItemLocations();
        selectCategory(lselectCategory,"9800");

        for (int i = 0; i < oemler.size(); i++) {
            findElement(lSeachBox).clear();
            OEM=oemler.get(i);
            findElement(lSeachBox).sendKeys(OEM, Keys.ENTER);


            allPruduct=findElements(lproducs);

            boolean oemdenListeVarmi = isOemdenListeVarmi();

            if (oemdenListeVarmi) { //oem bulunduysa


                for (int j = 0; j < allPruduct.size(); j++) {

                    if (j==5) {  // TODO: 1.03.2023 listeden ilk kaç ürünün analizi yapılacak
                        break;
                    }

                    List<String> windows;

                    try {
                        actions.moveToElement(allPruduct.get(j)).build().perform();
                        wait.until(ExpectedConditions.visibilityOf(allPruduct.get(j).findElement(urunTitle)));
                        title = allPruduct.get(j).findElement(urunTitle).getText();
                        wait.until(ExpectedConditions.visibilityOf(allPruduct.get(j).findElement(urunSaticiAdi)));
                        saticiAdi = allPruduct.get(j).findElement(urunSaticiAdi).getText();
                        wait.until(ExpectedConditions.visibilityOf(allPruduct.get(j).findElement(urunPrice)));
                        fiyat = allPruduct.get(j).findElement(urunPrice).getText();
                        wait.until(ExpectedConditions.visibilityOf(allPruduct.get(j).findElement(urunSonSatis)));
                        sonSatis = allPruduct.get(j).findElement(urunSonSatis).getText();
                        wait.until(ExpectedConditions.visibilityOf(allPruduct.get(j).findElement(urunfoto)));
                        fotoUrl = allPruduct.get(j).findElement(urunfoto).getAttribute("href");

                    }catch (Exception e){
                        continue;

                    }

                    try {
                        click(allPruduct.get(j).findElement(urunTitle));
                        windows = new ArrayList<>(driver.getWindowHandles());
                        driver.switchTo().window(windows.get(1));
                    }catch (Exception e){
                        actions.moveToElement(allPruduct.get(j).findElement(urunTitle))
                                .click().build().perform();
                        windows= new ArrayList<>(driver.getWindowHandles());
                        driver.switchTo().window(windows.get(1));
                    }

                    boolean urunEndMi = isUrunEndMi(lEndProduct);

                    if (! urunEndMi) {
                        avaleble="emty";
                        sold="emty";
                        postage="emty";
                        itemNumber="emty";
                        oOemlerTex="emty";
                        sellerLocation="emty";

                        try {
                            driver.close();
                            driver.switchTo().window(windows.get(0));
                        }catch (Exception e){
                            e.getMessage();
                            System.out.println("2.windows kapatılamadı veya 1'inci winwowsa geçilemedi");
                        }


                    }else {
                        try {
                            avaleble = findElement(lAvalible).getText();
                        }catch (Exception e){
                            avaleble="Listenin avalible bilgisi yok";
                        }
                        try {
                            sold = findElement(lsold).getText();
                        }catch (Exception e){
                            sold="Listenin sold bilgisi yok";
                        }
                        try {
                            postage=driver.findElement(lPotage).getText();
                        }catch (Exception e){
                            postage="Listenin postage bilgisi yok";
                        }
                        try {
                            actions.scrollToElement(findElement(lItemNumber)).build().perform();
                            itemNumber=driver.findElement(lItemNumber).getText();
                        }catch (Exception e){
                            itemNumber="Item number okunamadı";
                        }

                        try {
                            actions.scrollToElement(driver.findElement(lOemLists)).perform();
                            oOemlerTex=driver.findElement(lOemLists).getText();
                        }catch (Exception e){
                            oOemlerTex="Oemler Okunamadı. Geliştiriliyor...";
                        }
                        //new Actions(driver).scrollToElement(driver.findElement(lOemLists)).perform(); todo oem listesi yapılacak
                        //oOemlerTex=driver.findElement(lOemLists).getText();
                        try {
                            actions.scrollToElement(findElement(lSellerLocation)).build().perform();
                            sellerLocation=findElement(lSellerLocation).getText();
                        }catch (Exception e){
                            sellerLocation="Seller Locatios okunamadı";
                        }

                        driver.close();
                        driver.switchTo().window(windows.get(0));

                    }
                    finishList.add(OEM+"*"+title+"*"+saticiAdi+"*"+fiyat+"*"+sonSatis+"*"+fotoUrl+"*"+avaleble+"*"+sold+"*"+postage+"*"+itemNumber+"*"+oOemlerTex+"*"+sellerLocation);

                }

            }else {    //oem yoksa

                title=oemBulunamadi;
                saticiAdi=oemBulunamadi;
                fiyat=oemBulunamadi;
                sonSatis=oemBulunamadi;
                fotoUrl=oemBulunamadi;
                avaleble=oemBulunamadi;
                sold=oemBulunamadi;
                postage=oemBulunamadi;
                itemNumber=oemBulunamadi;
                oOemlerTex=oemBulunamadi;
                sellerLocation=oemBulunamadi;


              finishList.add(OEM+"*"+title+"*"+saticiAdi+"*"+fiyat+"*"+sonSatis+"*"+fotoUrl+"*"+avaleble+"*"+sold+"*"+postage+"*"+itemNumber+"*"+oOemlerTex+"*"+sellerLocation);

                // TODO: 1.03.2023 burası güncel olmalı
                //System.out.println(OEM+""+title+","+saticiAdi+","+fiyat+","+sonSatis+","+fotoUrl+","+avaleble+","+sold+","+postage+","+itemNumber+","+oOemlerTex+","+sellerLocation); // TODO: 1.03.2023 prpnt güncelle
            }

        }


        verileriYaz(finishList);
        driver.close();

    }

    private boolean isUrunEndMi(By lEndProduct) {
        boolean urunEndMi=false;

        try {
            findElement(lEndProduct).isDisplayed();
        } catch (Exception e) {
            urunEndMi=true;
        }
        return urunEndMi;
    }

    private boolean isOemdenListeVarmi() {
        boolean oemdenListeVarmi=false;
        try {
            findElement(lNoExactMatchesMound).isDisplayed();
        }catch (Exception e){
            oemdenListeVarmi=true;
        }
        return oemdenListeVarmi;
    }

    void selectCategory(By locator, String value) {
        select=new Select(findElement(locator));
        select.selectByValue(value);
    }
    void verileriYaz(List<String> products){

        try {
            FileWriter fw = new FileWriter("src/test/java/arraylist.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (String product : products) {
                bw.write(product);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void selectDemoItems() {
        findElement(lSeachBox).sendKeys("1432205", Keys.ENTER);

    }

    void selectItemLocations() {
        click(lItemLocation); // ıtem location click-1 // TODO: 3.03.2023
        click(lUkOnly); // ıtem location click-1
    }

    void selectNearFirstList() {
        click(findElement(lSortButton));
        click(findElement(lNearrestFirs));
    }

    private void selectBigMenu() {
        clickByAction(lBigFilter1);
        clickByAction(lBigFilter2);
        clickByAction(lBigFilter3);
        clickByAction(lBigFilter4);
        clickByAction(lBigFilter5);
        clickByAction(lBigFilter6);
        clickByAction(lBigFilter7);
        clickByAction(lBigFilter8);
        clickByAction(lBigFilter9);
        clickByAction(lBigFilter10);
        clickByAction(lBigFilter11);
    }
    private void clickByAction(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.moveToElement(findElement(locator)).click().build().perform();

    }
    void selectCauntry(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        click(lpostage_to);
        click(lselect);
        new Select(driver.findElement(lSelectCauntry)).selectByVisibleText("United Kingdom - GBR");
        click(lGoButton);


    }


}

