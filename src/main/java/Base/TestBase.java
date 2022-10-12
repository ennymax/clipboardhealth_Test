package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.LandingPage;
import pages.SamsungPage;
import utility.OptionsManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import static utility.Utility.fetchvalue;

public abstract class TestBase {

    protected static LandingPage landingPage;
    protected static SamsungPage samsungPage;

    protected OptionsManager optionsManager;
    public static ThreadLocal<WebDriver> getdriver = new ThreadLocal<>();

    @BeforeTest(alwaysRun = true)
    public void SetUp() {
        optionsManager = new OptionsManager();

        switch (fetchvalue("BrowserName")) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                getdriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
                break;

            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                getdriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
                break;

            case "RemoteChrome":
                Remotebrowser("chrome");
                break;

            case "RemoteFirefox":
                Remotebrowser("firefox");
                break;
        }

        landingPage = new LandingPage();
        samsungPage = new SamsungPage();

        getdriver.get().manage().window().maximize();
        getdriver.get().get(fetchvalue("UrlPROD"));

        getdriver.get().manage().deleteAllCookies();
        getdriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(fetchvalue("PageLoad.wait"))));
        getdriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(fetchvalue("implicit.wait"))));
    }

    private void Remotebrowser(String browserName) {

        System.out.println("Running tests on remote grid server: " + browserName);

        if (browserName.equalsIgnoreCase("chrome")) {
            try {
                getdriver.set(
                        new RemoteWebDriver(new URL(fetchvalue("RemoteURL")), optionsManager.getChromeOptions()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (browserName.equalsIgnoreCase("firefox")) {
            try {
                getdriver.set(
                        new RemoteWebDriver(new URL(fetchvalue("RemoteURL")), optionsManager.getFirefoxOptions()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

    }

    @AfterTest(alwaysRun = true)
    public void Quit() {
        getdriver.get().quit();
    }
}