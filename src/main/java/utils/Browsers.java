package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariOptions;

public enum Browsers {
    CHROME {
        public WebDriver create() {
            return WebDriverManager.chromedriver().create();
        }
    },
    FIREFOX {
        public WebDriver create() {
            return WebDriverManager.firefoxdriver().create();
        }
    },
    OPERA {
        public WebDriver create() {
            return WebDriverManager.operadriver().create();
        }
    },
    IE {
        public WebDriver create() {
            return WebDriverManager.iedriver().create();
        }
    },
    SAFARI {
        public WebDriver create() {
            return WebDriverManager.safaridriver().create();
        }
    },

    CONFIG_BROWSER {
        public WebDriver create() {
            return switch (ConfigProvider.browser) {
                case "CHROME" -> WebDriverManager.chromedriver().capabilities(chromeOps()).create();
                case "FIREFOX" -> WebDriverManager.firefoxdriver().capabilities(firefoxOps()).create();
                case "OPERA" -> WebDriverManager.operadriver().capabilities(operaOps()).create();
                case "IE" -> WebDriverManager.iedriver().capabilities(ieOps()).create();
                case "SAFARI" -> WebDriverManager.safaridriver().capabilities(safariOps()).create();
                default -> throw new RuntimeException("Incorrect config browser");
            };
        }
    };
    public abstract WebDriver create();

    public ChromeOptions chromeOps() {
        ChromeOptions ops = new ChromeOptions();
        ops.setHeadless(ConfigProvider.headless);
        if (!ConfigProvider.page_load_strategy) ops.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return ops;
    }

    public FirefoxOptions firefoxOps() {
        FirefoxOptions ops = new FirefoxOptions();
        ops.setHeadless(ConfigProvider.headless);
        if (!ConfigProvider.page_load_strategy) ops.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return ops;
    }

    public ChromeOptions operaOps() {
        ChromeOptions ops = new ChromeOptions();
        ops.setHeadless(ConfigProvider.headless);
        if (!ConfigProvider.page_load_strategy) ops.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return ops;
    }

    public InternetExplorerOptions ieOps() {
        InternetExplorerOptions ops = new InternetExplorerOptions();
        if (ConfigProvider.headless) System.out.println("There is no headless mode for IE browser");
        if (!ConfigProvider.page_load_strategy) ops.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return ops;
    }

    public SafariOptions safariOps() {
        SafariOptions ops = new SafariOptions();
        if (ConfigProvider.headless) System.out.println("There is no headless mode for Safari browser");
        if (!ConfigProvider.page_load_strategy) ops.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return ops;
    }
}
