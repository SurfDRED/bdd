package ru.netology.bdd.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.bdd.data.DataHelper;
import static com.codeborne.selenide.Selenide.$;

public class DepositPage {
    private SelenideElement transferAmount = $("[data-test-id=amount] input");
    private SelenideElement whichCard = $("[data-test-id=from] input");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");

    public DashboardPage transferAmountFromSecondCard (int amounts, DataHelper.CardSecond secondCard){
        transferAmount.setValue(String.valueOf(amounts));
        whichCard.setValue(secondCard.getCardSecondNumber());
        transferButton.click();
        return new DashboardPage();
    }
    public DashboardPage transferAmountFromFirstCard (int amounts, DataHelper.CardFirst firstCard){
        transferAmount.setValue(String.valueOf(amounts));
        whichCard.setValue(firstCard.getCardFirstNumber());
        transferButton.click();
        return new DashboardPage();
    }

    public void ClearingFields (){
        transferAmount.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        whichCard.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
}
