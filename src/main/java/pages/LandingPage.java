package pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static utility.JavaScriptUtil.*;

public class LandingPage extends TestBase {

    public static String HomeTittle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

    @FindBy(id = "nav-hamburger-menu")
    @CacheLookup
    private WebElement HamburgerMenu;

    @FindBy(xpath = "//span[text()='Brands' and @class='a-size-base a-color-base a-text-bold']")
    @CacheLookup
    private WebElement Brand;

    @FindBy(xpath = "//span[@class='a-size-base a-color-base'][contains(.,'Samsung')]")
    @CacheLookup
    private WebElement checkbox_samsung;

    @FindBy(xpath = "//a[@class='hmenu-item' and @ data-ref-tag='nav_em_1_1_1_14']")
    @CacheLookup
    private WebElement tv_ele_menu;

    @FindBy(xpath = "//a[contains(.,'Televisions')]")
    @CacheLookup
    private WebElement television;

    @FindBy(xpath = "//div[contains(text(),'shop by category') and @class='hmenu-item hmenu-title ']")
    @CacheLookup
    private WebElement shop_by_category;

    @FindBy(xpath = "(//span[contains(@data-csa-c-type,'widget')])[1]")
    @CacheLookup
    private WebElement sortby;

    @FindBy(xpath = "//a[contains(@id,'s-result-sort-select_2')]")
    @CacheLookup
    private WebElement hightolow;

    public LandingPage() {
        PageFactory.initElements(getdriver.get(), this);
    }

    public LandingPage hamburgermenu() {
        HamburgerMenu.click();
        return this;
    }

    public LandingPage select_tv_app_elect() {
        //scrolling shop by category into view
        DoScrollIntoView(shop_by_category);
        DoClick(tv_ele_menu);
        return this;
    }

    public LandingPage select_televisions() {
        television.click();
        return this;
    }

    public LandingPage Scrowl_brand_to_view() {
        DoScrollIntoView(Brand);
        return this;
    }

    public LandingPage sort() {
        DoClick(sortby);
        return this;
    }

    public LandingPage High_to_low() {
        DoClick(hightolow);
        return this;
    }

    public static boolean CheckHomeTittle() throws InterruptedException {
        return getdriver.get().getTitle().contains(HomeTittle);
    }
}
