import org.openqa.selenium.By;

public interface Locators {
    By lSeachBox= By.xpath("//input[@id='gh-ac']");
    By lSoldItemClick=By.xpath("//input[@aria-label='Sold items']");
    By lSelectCaunty=By.xpath("//div[@class=\"srp-controls__row-cells right\"]");
    By lSelectCauntyMenu=By.xpath("//span[@class=\"select\"]/select");
    By element=By.xpath("//span[@class=\"select\"]/select");

    //region Select Cauntry Locators
    By lpostage_to=By.xpath("//span[text()='Postage to: ']");
    By lselect=By.xpath("//span[@class='select']/select");
    By lSelectCauntry=By.xpath("//span[@class='select']/select");
    By lGoButton=By.xpath("//input[@value='Go']");
    //endregion


    //region selectNearFirstList
    By lSortButton=By.xpath("(//div[contains(@class,'srp-controls')])[8]//button");
    By lNearrestFirs=By.xpath("//li/a/span[text()='Nearest first']");
    //endregion



    //region Locasyon lokators
    By lItemLocation=By.xpath("//span[(text()='Item location')]"); // item locator sections
    By lUkOnly=By.xpath("//span[contains(@class,'filter-menu-button')]//span[text()='UK Only']"); //uk only locator
    //endregion


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


    By lBigFilter1=By.xpath("//button[text()='More filters...']"); //More filters Button
    By lBigFilter2=By.xpath("//div[@role='tablist']//span[text()='Condition']"); //condition section
    By lBigFilter3=By.xpath("(//div[@role='tabpanel']//.//div/label)[1]"); //new Checbox

    By lBigFilter4=By.xpath("//div[@role='tablist']//span[text()='Seller']"); //Seller section
    By lBigFilter5=By.xpath("//div[@role='tabpanel']//*[text()='Only show items from:']"); //Only show items from checbox
    By lBigFilter6=By.xpath("//div[@role='tabpanel']//*[text()='Sellers with eBay Shops']"); //Sellers with eBay Shops checboxk
    By lBigFilter7=By.xpath("//div[@role='tabpanel']//*[text()='Seller type:']"); //Seller type: checkboxx
    By lBigFilter8=By.xpath("//div[@role='tabpanel']//*[text()='Business']"); //Busines checboxs

    By lBigFilter9=(By.xpath("//div[@role='tablist']//span[text()='Show only']")); //Show only sections
    By lBigFilter10=By.xpath("//div[@role='tabpanel']//*[text()='Sold items']"); //sold item checbox
    By lBigFilter11=By.xpath("//button[text()='Apply']"); //apply button


}
