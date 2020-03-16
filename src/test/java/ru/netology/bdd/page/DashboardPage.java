package ru.netology.bdd.page;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    public void ReturnDashboardPage() {
        $("[data-test-id=dashboard]").shouldBe(Condition.visible);
        $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button").shouldBe(Condition.visible);
        $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] button").shouldBe(Condition.visible);
    }

    public int BalanceFirstCard() {
        String BalanceFirstCard = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']").getText();
        int FirstCardStart = BalanceFirstCard.indexOf("баланс: ");
        int FirstCardEnd = BalanceFirstCard.indexOf(" р.");
        String balance = BalanceFirstCard.substring(FirstCardStart + 8, FirstCardEnd);
        return Integer.parseInt(balance);
    }

    public int BalanceSecondCard() {
        String BalanceFirstCard = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']").getText();
        int SecondCardStart = BalanceFirstCard.indexOf("баланс: ");
        int SecondCardEnd = BalanceFirstCard.indexOf(" р.");
        String balance = BalanceFirstCard.substring(SecondCardStart + 8, SecondCardEnd);
        return Integer.parseInt(balance);
    }

    public DepositPage transferFirstCard() {
        $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button").click();
        return new DepositPage();
    }
    public DepositPage transferSecondCard() {
        $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] button").click();
        return new DepositPage();
    }
}
