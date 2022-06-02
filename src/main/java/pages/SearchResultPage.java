package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@jsname='N10B9']")
    private WebElement oneDigitButton;

    @FindBy(xpath = "//div[@jsname='lVjWed']")
    private WebElement twoDigitButton;

    @FindBy(xpath = "//div[@jsname='KN1kY']")
    private WebElement threeDigitButton;

    @FindBy(xpath = "//div[@jsname='XSr6wc']")
    private WebElement plusButton;

    @FindBy(xpath = "//div[@jsname='pPHzQc']")
    private WebElement minusButton;

    @FindBy(xpath = "//div[@jsname='YovRWb']")
    private WebElement multiplyButton;

    @FindBy(xpath = "//div[@jsname='Pt8tGc']")
    private WebElement equallyButton;

    @FindBy(xpath = "//span[@class='vUGUtc']")
    private WebElement enteredFormula;

    @FindBy(id = "cwos")
    private WebElement result;

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    public SearchResultPage calculate() {
        oneDigitButton.click();
        multiplyButton.click();
        twoDigitButton.click();
        minusButton.click();
        threeDigitButton.click();
        plusButton.click();
        oneDigitButton.click();
        equallyButton.click();
        return new SearchResultPage();
    }

    public String getEnteredFormula() {
        return enteredFormula.getText();
    }

    public String getResult() {
        return result.getText();
    }
}
