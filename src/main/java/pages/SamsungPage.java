package pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static utility.JavaScriptUtil.DoClick;
import static utility.JavaScriptUtil.DoScrollIntoView;

public class SamsungPage extends TestBase {

    public static String samsungtittle ="Amazon.in";
    public static String aboutitem = "About this item";

    @FindBy(xpath = "//div[@class='a-section a-spacing-medium a-spacing-top-small']")
    @CacheLookup
    private WebElement itemdetails;

    @FindBy(xpath = "//span[contains(text(),'Samsung') and @class='a-size-base a-color-base']")
    @CacheLookup
    private WebElement samsung;

    @FindBy(xpath = "//span[@class='a-button-text a-declarative']")
    @CacheLookup
    private WebElement sortby;

    @FindBy(xpath = "//a[contains(@id,'s-result-sort-select_2')]")
    @CacheLookup
    private WebElement hightolow;

    @FindBy(xpath = "//span[text()='Brands' and @class='a-size-base a-color-base a-text-bold']")
    @CacheLookup
    private WebElement Brand;

    @FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]")
    @CacheLookup
    private WebElement secondhighestprice;

    @FindBy(xpath = "//h1[contains(text(),'About this item') and @class='a-size-base-plus a-text-bold']")
    @CacheLookup
    private WebElement aboutthisitem;

    public SamsungPage() {
        PageFactory.initElements(getdriver.get(), this);
    }

    public SamsungPage selectsamsung() {
        samsung.click();
        return this;
    }

    public SamsungPage sort() {
        DoClick(sortby);
        return this;
    }

    public SamsungPage High_to_low() throws InterruptedException {
        DoClick(hightolow);
        return this;
    }

    public SamsungPage selectsecondhighestprice() {
        DoClick(secondhighestprice);
        return this;
    }

    public String getaboutitemdetails() {
        return itemdetails.getText();
    }

    public String getsecondHighestproze() {
        return secondhighestprice.getText();
    }

    public String get_about_item_text() {
        return aboutthisitem.getText();
    }

    public static boolean Check_samsungpagetittle() throws InterruptedException {
        return getdriver.get().getTitle().contains(samsungtittle);
    }
}
