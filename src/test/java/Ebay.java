
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;


public class Ebay extends BaseClass implements Locators{
    @Test
    public void FisrtTest() {

        List<String> oemler = getOem();

        driver.get(URL);
        List<WebElement> allPruduct;

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

        findElement(lSeachBox).sendKeys("1432205", Keys.ENTER);
        if (! findElement(lSoldItemClick).isSelected()) {
            findElement(lSoldItemClick).click();
        }
        click(findElement(lSelectCaunty));
        click(findElement(element));


        Select select=new Select(findElement(lSelectCauntyMenu));
        select.selectByValue("3");
        click(findElement(lGOButton));
        click(findElement(lSortButton));
        click(findElement(lNearrestFirs));

        for (int i = 0; i < oemler.size(); i++) {
            findElement(lSeachBox).clear();
            OEM=oemler.get(i);
            findElement(lSeachBox).sendKeys(oemler.get(i), Keys.ENTER);
            boolean oemdenListeVarmi=false;

            try {
                findElement(lNoExactMatchesMound).isDisplayed();
            }catch (Exception e){
                oemdenListeVarmi=true;
            }


            if (oemdenListeVarmi) { //oem bulunduysa

                allPruduct= findElements(lproducs);

                for (int j = 0; j < allPruduct.size(); j++) {
                    actions(allPruduct.get(j));
                    title = allPruduct.get(j).findElement(urunTitle).getText();
                    saticiAdi = allPruduct.get(j).findElement(urunSaticiAdi).getText();
                    fiyat = allPruduct.get(j).findElement(urunPrice).getText();
                    sonSatis = allPruduct.get(j).findElement(urunSonSatis).getText();
                    fotoUrl = allPruduct.get(j).findElement(urunfoto).getAttribute("href");
                    ;

                    //ilk ürüne clicK
                    click(allPruduct.get(j).findElement(urunTitle));
                    List<String> windowslar = driver.getWindowHandles().stream().toList();
                    driver.switchTo().window(windowslar.get(1));

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


                        driver.close();
                        driver.switchTo().window(windowslar.get(0));

                    }else {

                        avaleble = findElement(lAvalible).getText();
                        sold = findElement(lsold).getText();
                        actions(findElement(lPotage));
                        postage=driver.findElement(lPotage).getText();
                        actions(findElement(lItemNumber));
                        itemNumber=driver.findElement(lItemNumber).getText();
                        //new Actions(driver).scrollToElement(driver.findElement(lOemLists)).perform(); todo oem listesi yapılacak
                        //oOemlerTex=driver.findElement(lOemLists).getText();
                        try {
                            actions(findElement(lSellerLocation));
                        }catch (Exception e){
                            sellerLocation="seller manuel bak";
                        }
                        sellerLocation=findElement(lSellerLocation).getText();

                        driver.close();
                        driver.switchTo().window(windowslar.get(0));

                    }


                    System.out.println(OEM+","+title+","+saticiAdi+","+fiyat+","+sonSatis+","+fotoUrl+","+avaleble+","+sold+","+postage+","+itemNumber+","+oOemlerTex+","+sellerLocation);

                    if (j==3) {  // TODO: 1.03.2023 listeden ilk kaç ürünün analizi yapılacak
                        break;
                    }
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

                // TODO: 1.03.2023 burası güncel olmalı

                System.out.println(OEM+","+title+","+saticiAdi+","+fiyat+","+sonSatis+","+fotoUrl+","+avaleble+","+sold+","+postage+","+itemNumber); // TODO: 1.03.2023 prpnt güncelle


            }          

        }

    }


}

