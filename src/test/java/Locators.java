import org.openqa.selenium.By;

public interface Locators {
    By lSeachBox= By.xpath("//input[@id='gh-ac']");
    By lSoldItemClick=By.xpath("//input[@aria-label='Sold items']");
    By lSelectCaunty=By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[2]/div/button");
    By lSelectCauntyMenu=By.xpath("//*[@id=\"s0-51-12-5-4[0]-56-21-0-7-13-select\"]");
    By element=By.xpath("//*[@id=\"s0-51-12-5-4[0]-56-21\"]/form/fieldset/div[1]/span/span");
    By lGOButton=By.xpath("//*[@id=\"s0-51-12-5-4[0]-56-21\"]/form/fieldset/input");
    By lSortButton=By.xpath("//*[@id=\"s0-51-12-5-4[0]\"]/div[3]");
    By lNearrestFirs=By.xpath("//*[@id=\"s0-51-12-5-4[0]-40-1-content-menu\"]/li[7]");
    By lproducs=By.xpath("//div[@id=\"srp-river-results\"]//div[@class='s-item__wrapper clearfix']");


    By urunSonSatis=By.xpath(".//span");
    By urunTitle=By.xpath(".//span[@role=\"heading\"]");
    By urunPrice=By.xpath(".//span[@class=\"s-item__price\"]/span");
    By urunSaticiAdi=By.xpath(".//span[@class=\"s-item__seller-info-text\"]");
    By urunfoto=By.xpath(".//div[@class=\"s-item__image\"]/a");
    //String urunFoto = driver.findElement(urunfoto).getAttribute("href");
    By lEndProduct=By.xpath("//div[@id='CenterPanel']//*[contains(.,\"This listing has ended.\")]");
    By lAvalible=By.xpath("//div[@class='d-quantity__availability']//span[1]");
    By lsold=By.xpath("//div[@class='d-quantity__availability']//span[3]");
    By lPotage=By.xpath("(//div[contains(@class,'ux-labels-values')]//div//span[contains(@class,'ux-textspans ux-textspans--')])[2]");
    By lItemNumber=By.xpath("//div[@id='readMoreDesc']//span[contains(@class,'ux-textspans ux-textspans--BOLD')]");
    By lNoExactMatchesMound=By.xpath("//div[@class='srp-save-null-search']//*[contains(text(),'No exact matches found')]");
    By lOemLists=By.xpath("(//div[@data-testid='ux-layout-section']//div[@class='ux-layout-section__item ux-layout-section__item--table-view']//div[5]//span)[4]");
    By lSellerLocation=By.xpath("(//div[@data-testid='ux-section'])[6]//div[6] | (//div[@data-testid='ux-section'])[6]//div[5]");

}
