import Base.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import static pages.LandingPage.*;
import static pages.SamsungPage.*;
import static utility.TabHandle.TabHandle;

@Epic("Epic 100 - Landing PAge of Amazon Portal")
@Story("Story 100 - Landing PAge of Amazon Portal")
public class Amazon_in extends TestBase {

    @Description("Assert Home page tittle")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void AmazonLandingPage() throws InterruptedException {
        Assert.assertTrue(CheckHomeTittle());
    }


    @Description("Select Television Set")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void HamBurger_menu() throws InterruptedException {
        landingPage.hamburgermenu();
        landingPage.select_tv_app_elect();
        Thread.sleep(5000);
        landingPage.select_televisions();
    }


    @Description("Choose samsung brand")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void Filter_result_by_brand() throws InterruptedException {
        landingPage.Scrowl_brand_to_view();
        samsungPage.selectsamsung();
        Assert.assertTrue(Check_samsungpagetittle());
        samsungPage.sort();
    }

    @Description("Assert and select the second highest price")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void Samsungtest() throws InterruptedException {
        samsungPage.High_to_low();
        samsungPage.selectsecondhighestprice();
    }


    @Description("Navigate to the About tab and assert item information")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public static void AboutSamsungTest() throws InterruptedException, IOException {
        TabHandle();
        Assert.assertEquals(samsungPage.get_about_item_text(),aboutitem);
        System.out.println(samsungPage.getaboutitemdetails());
    }
}
