package utils;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;

import java.util.Optional;

public class Listener implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable)
    {
        Allure.getLifecycle().addAttachment("failedScreenshot",
                "image/png",
                "png",
                ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.BYTES));
        if (BasePage.driver != null) {
            BasePage.driver.close();
            BasePage.driver.quit();
        }
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        Allure.getLifecycle().addAttachment("failedScreenshot",
                "image/png",
                "png",
                ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.BYTES));
        if (BasePage.driver != null) {
            BasePage.driver.close();
            BasePage.driver.quit();
        }
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        if (BasePage.driver != null) {
            BasePage.driver.close();
            BasePage.driver.quit();
        }
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        if (BasePage.driver != null) {
            BasePage.driver.close();
            BasePage.driver.quit();
        }
    }
}
