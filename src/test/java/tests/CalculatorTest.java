package tests;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.HomePage;
import pages.SearchResultPage;
import utils.Listener;

@ExtendWith(Listener.class)
public class CalculatorTest extends BaseTest {

    @Test
    @DisplayName("Calculator Test")
    @Description(value = "Open google.com, enter calculator, calculate «1 * 2 - 3 + 1»")
    public void calculatorTest() {
        String enteredFormula = "1 × 2 - 3 + 1 =";
        String result = "0";

        SearchResultPage searchResultPage = new SearchResultPage();

        new HomePage()
                .searchSomething("Калькулятор")
                .calculate();

        Assertions.assertThat(searchResultPage.getEnteredFormula()).isEqualTo(enteredFormula);
        Assertions.assertThat(searchResultPage.getResult()).isEqualTo(result);
    }


}
