package tests;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import utils.Browsers;
import utils.ConfigProvider;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        driver = Browsers.CONFIG_BROWSER.create();
        if (driver == null) {
            throw new Exception("Browser " + ConfigProvider.browser + " is not installed");
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        TakesScreenshot screenShooter = (TakesScreenshot) driver;
        Actions action = new Actions(driver);
        if (ConfigProvider.fullscreen) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.implicit_wait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigProvider.page_load_time));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProvider.explicit_wait));
        BasePage.setDriver(driver);
        BasePage.setWaiter(wait);
        BasePage.setJSExecutor(js);
        BasePage.setScreenShooter(screenShooter);
        BasePage.setActions(action);
    }
}
