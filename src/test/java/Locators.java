import org.openqa.selenium.By;

public interface Locators {
    By lSeachBox= By.xpath("//input[@id='gh-ac']");
    By lSoldItemClick=By.xpath("//input[@aria-label='Sold items']");
    By lSelectCaunty=By.xpath("//div[@class=\"srp-controls__row-cells right\"]");
    By lSelectCauntyMenu=By.xpath("//span[@class=\"select\"]/select");
    By element=By.xpath("//span[@class=\"select\"]/select");

    By lSelectCaunty2=By.xpath("//div[@class=\"srp-controls__row-cells right\"]");
    By lselectCauntyMenu=By.xpath("//div[@aria-label='Information']//span[@class='floating-label']");

    By getlGOButton2=By.xpath("//form[@class='srp-shipping-location__form']//fieldset/input");
    By lselect=By.xpath("//*[@id=\"s0-51-12-5-4[0]-47-21\"]/form/fieldset/div[1]/span//select");

    By lGOButton=By.xpath("//*[@id=\"s0-51-12-5-4[0]-56-21\"]/form/fieldset/input");
    By lSortButton=By.xpath("//*[@id=\"s0-51-12-5-4[0]\"]/div[3]");
    By lNearrestFirs=By.xpath("//*[@id=\"s0-51-12-5-4[0]-40-1-content-menu\"]/li[1]");
    By lCategori=By.xpath("//span[contains(.,'Vehicle Parts & Accessories')]");
    By lComdition=By.xpath("//button[contains(.,'Condition')]");
    By lUnCheckAnyCondition=By.xpath("(//span[contains(.,'Any condition')])[3]");
    By lNewChecked=By.xpath("//div[@role='menuitemcheckbox']//span[contains(.,'New')]");

    By lItemLocation=By.xpath("(//div[@class=\"srp-controls__resize-display\"]//span[contains(@class,\"filter-menu-button srp-\")])[2]//button");
    By lUkOnly=By.xpath("(//div[@class=\"filter-menu-button__items\"])[3]//div[2]");
    By lselectCategory=By.xpath("//*[@id=\"gh-cat\"]");


    By lproducs=By.xpath("//div[@id=\"srp-river-results\"]//div[@class='s-item__wrapper clearfix']");
    By urunSonSatis=By.xpath(".//span");
    By urunTitle=By.xpath(".//div[@class=\"s-item__title\"]");
    By urunPrice=By.xpath(".//span[@class=\"s-item__price\"]/span");
    By urunSaticiAdi=By.xpath(".//span[@class=\"s-item__seller-info-text\"]");
    By urunfoto=By.xpath(".//div[@class=\"s-item__image\"]/a");
    //String urunFoto = driver.findElement(urunfoto).getAttribute("href");
    By lEndProduct=By.xpath("//div[@id='CenterPanel']//*[contains(.,\"ended\")]");
    By lAvalible=By.xpath("//div[@class='d-quantity__availability']//span[1]");
    By lsold=By.xpath("//div[@class='d-quantity__availability']//span[3]");
    By lPotage=By.xpath("(//div[contains(@class,'ux-labels-values')]//div//span[contains(@class,'ux-textspans ux-textspans--')])[2]");
    By lItemNumber=By.xpath("//div[@id='readMoreDesc']//span[contains(@class,'ux-textspans ux-textspans--BOLD')]");
    By lNoExactMatchesMound=By.xpath("//div[@class='srp-save-null-search']//*[contains(text(),'No exact matches found')]");
    By lOemLists=By.xpath("(//div[@data-testid='ux-layout-section']//div[@class='ux-layout-section__item ux-layout-section__item--table-view']//div[5]//span)[4]");
    By lSellerLocation=By.xpath("(//div[@data-testid='ux-section'])[6]//div[6] | (//div[@data-testid='ux-section'])[6]//div[5]");


    By lBigFilter1=By.xpath("//*[@id=\"s0-51-12-0-1-2-6\"]/li[2]/span/button");
    By lBigFilter2=By.xpath("//div[@class='x-overlay-main-panel__aspects']//div[7]");
    By lBigFilter3=By.xpath("//*[@id=\"c3-subPanel-LH_ItemCondition_New\"]/label");
    By lBigFilter4=By.xpath("//div[@class='x-overlay-main-panel__aspects']//div[10]");
    By lBigFilter5=By.xpath("//*[@id=\"c3-subPanel-_x-seller[0]\"]/label");
    By lBigFilter6=By.xpath("//*[@id=\"c3-subPanel-_x-seller[0]-4[1]\"]/div/div/label");
    By lBigFilter7=By.xpath("//*[@id=\"c3-subPanel-_x-seller[1]\"]/label");
    By lBigFilter8=By.xpath("//*[@id=\"c3-subPanel-_x-seller[1]-4[0]\"]/div/div/label");
    By lBigFilter9=By.xpath("//*[@id=\"c3-mainPanel-globals\"]");
    By lBigFilter10=By.xpath("//*[@id=\"c3-subPanel-LH_Sold_Sold%20items\"]/label/div");
    By lBigFilter11=By.xpath("//*[@id=\"c3-footerId\"]/div[2]/button");


}
