package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor js;
    protected static TakesScreenshot screenShooter;
    protected static Actions actions;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
    public static void setWaiter(WebDriverWait webDriverwait) { wait = webDriverwait; }
    public static void setJSExecutor(JavascriptExecutor jsExecutor) { js = jsExecutor; }
    public static void setScreenShooter(TakesScreenshot scrnShooter) { screenShooter = scrnShooter; }
    public static void setActions(Actions action) { actions = action; }

}
