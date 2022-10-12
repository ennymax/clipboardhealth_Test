package utility;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class JavaScriptUtil extends TestBase {

    public static void DoClick(WebElement locator) {
        JavascriptExecutor executor = (JavascriptExecutor) getdriver.get();
        executor.executeScript("arguments[0].click();", locator);
    }

    public static void DoScrollIntoView(WebElement locator){
        JavascriptExecutor jse = (JavascriptExecutor) getdriver.get();
        jse.executeScript("arguments[0].scrollIntoView();", locator);
    }


}
