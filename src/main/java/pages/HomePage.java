package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigProvider;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement search;

    @FindBy(xpath = "//div[@class='FPdoLc lJ9FBc']//input[@name=\"btnK\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='o3j99 LLD4me yr19Zb LS8OJ']")
    private WebElement noElementSpace;

    public HomePage() {
        driver.get(ConfigProvider.url);
        PageFactory.initElements(driver, this);
    }

    @Step
    public SearchResultPage searchSomething(String searchWord) {
        search.sendKeys(searchWord);
        noElementSpace.click();
        searchButton.click();
        return new SearchResultPage();
    }
}
