
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.*;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;


public class Ebay extends BaseClass implements Locators{


    @Test
    public void FisrtTest() {

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

        driver.get(URL);
        List<WebElement> allPruduct;
        List<String> Link;

        selectSoldItems();
        selectCatogy();
        selectCaunty();
        selectNearFirstList();
        yeniUrunleriSec();
        selectItemLocations();

        for (int i = 0; i < oemler.size(); i++) {
            findElement(lSeachBox).clear();
            OEM=oemler.get(i);
            findElement(lSeachBox).sendKeys(OEM, Keys.ENTER);

            //yeniUrunleriSec();

            allPruduct=findElements(lproducs);

            boolean oemdenListeVarmi=false;
            try {
                findElement(lNoExactMatchesMound).isDisplayed();
            }catch (Exception e){
                oemdenListeVarmi=true;
            }

            if (oemdenListeVarmi) { //oem bulunduysa


                for (int j = 0; j < allPruduct.size(); j++) {

                    if (j==2) {  // TODO: 1.03.2023 listeden ilk kaç ürünün analizi yapılacak
                        break;
                    }

                    List<String> windows;

                    try {
                        actions(allPruduct.get(j));
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

                        //ilk ürüne clicK
                        wait.until(ExpectedConditions.visibilityOf(allPruduct.get(j).findElement(urunTitle)));

                    }catch (Exception e){
                        continue;

                    }

                    try {
                        click(allPruduct.get(j).findElement(urunTitle));
                        windows = new ArrayList<>(driver.getWindowHandles());
                        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
                        driver.switchTo().window(windows.get(1));
                    }catch (Exception e){
                        actions.moveToElement(allPruduct.get(j).findElement(urunTitle))
                                .click(allPruduct.get(j).findElement(urunTitle)).build().perform();
                        windows= new ArrayList<>(driver.getWindowHandles());
                        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
                        driver.switchTo().window(windows.get(1));
                    }

                    boolean urunEndMi=false;

                    try {
                        findElement(lEndProduct).isDisplayed();
                    } catch (Exception e) {
                        urunEndMi=true;
                    }

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


                    }
                    else {
                        try {
                            avaleble = findElement(lAvalible).getText();
                        }catch (Exception e){
                            avaleble="Listenin avalinle bilgisi yok";
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
                    finishList.add(OEM+","+title+","+saticiAdi+","+fiyat+","+sonSatis+","+fotoUrl+","+avaleble+","+sold+","+postage+","+itemNumber+","+oOemlerTex+","+sellerLocation);
                    //System.out.println(OEM+","+title+","+saticiAdi+","+fiyat+","+sonSatis+","+fotoUrl+","+avaleble+","+sold+","+postage+","+itemNumber+","+oOemlerTex+","+sellerLocation);
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


                finishList.add(OEM+","+title+","+saticiAdi+","+fiyat+","+sonSatis+","+fotoUrl+","+avaleble+","+sold+","+postage+","+itemNumber+","+oOemlerTex+","+sellerLocation);

                // TODO: 1.03.2023 burası güncel olmalı
                //System.out.println(OEM+","+title+","+saticiAdi+","+fiyat+","+sonSatis+","+fotoUrl+","+avaleble+","+sold+","+postage+","+itemNumber+","+oOemlerTex+","+sellerLocation); // TODO: 1.03.2023 prpnt güncelle
            }

        }


        verileriYaz(finishList);

    }

    private void verileriYaz(List<String> list){


        try {
            FileWriter fw = new FileWriter("src/test/java/arraylist.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (String str : list) {
                bw.write(str);
                bw.newLine();
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void selectCatogy() {
        click(findElement(lCategori)); //kategori seçimi
    }

    private void selectSoldItems() {
        findElement(lSeachBox).sendKeys("1432205", Keys.ENTER);
        if (! findElement(lSoldItemClick).isSelected()) {
            actions.scrollToElement(findElement(lSoldItemClick)).build().perform();
            findElement(lSoldItemClick).click();
        }
    }

    private void selectItemLocations() {
        click(lItemLocation); // ıtem location click-1 // TODO: 3.03.2023
        click(lUkOnly); // ıtem location click-1
    }

    private void selectNearFirstList() {
        click(findElement(lSortButton));
        click(findElement(lNearrestFirs));
    }

    private void selectCaunty() {
        try {
            click(findElement(lSelectCaunty)); // caunty seç
            click(findElement(element));
            Select select=new Select(findElement(lSelectCauntyMenu));
            select.selectByValue("3");
            click(findElement(lGOButton));
        } catch (Exception e) {
            click(findElement(lSelectCaunty2)); //yeri başka ise ikinci caunty
            click(findElement(lselectCauntyMenu));
            Select select=new Select(findElement(lselect));
            select.selectByValue("3");
            click(findElement(getlGOButton2));
        }
    }

    private void yeniUrunleriSec() {
        click(lComdition);  //condition click
        click(lUnCheckAnyCondition);
        try {
            Thread.sleep(1_000);
        } catch (Exception e) {
            e.getMessage();
        }
        try {
            click(lNewChecked); //new cilik
        }catch (Exception e){

        }

    }

}

