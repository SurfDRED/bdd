package ru.netology.bdd.test;

import lombok.val;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.netology.bdd.data.DataHelper;
import ru.netology.bdd.page.DashboardPage;
import ru.netology.bdd.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransfer {
    private static DashboardPage dashboardPage;

    @BeforeAll
    static void shouldTransferInitial() {
    open("http://localhost:9999");
    val loginPage = new LoginPage();
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    dashboardPage = verificationPage.validVerify(verificationCode);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TransferMoney.csv", numLinesToSkip = 1)
    void shouldTransferMoney(int amount1, int expected1, int amount2, int expected2, String message) {

        //перевод на 1 карту
        val balancePageFirstCard = dashboardPage.BalanceFirstCard();
        val transferPageFirstCard = dashboardPage.transferFirstCard();
        transferPageFirstCard.ClearingFields();
        val secondCard = DataHelper.getCardSecond();
        transferPageFirstCard.transferAmountFromSecondCard(amount1, secondCard);
        assertEquals(expected1, balancePageFirstCard + amount1);
        dashboardPage.ReturnDashboardPage();

        //перевод на 2 карту
        val balancePageSecondCard = dashboardPage.BalanceSecondCard();
        val transferPageSecondCard = dashboardPage.transferSecondCard();
        transferPageSecondCard.ClearingFields();
        val firstCard = DataHelper.getCardFirst();
        transferPageSecondCard.transferAmountFromFirstCard(amount2, firstCard);
        assertEquals(expected2, balancePageSecondCard + amount2);
        dashboardPage.ReturnDashboardPage();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TransferMoneyBug.csv", numLinesToSkip = 1)
    void shouldTransferMoneyBug(int amount1, int expected1, int amount2, int expected2, String message) {

        //перевод на 1 карту
        val balancePageFirstCard = dashboardPage.BalanceFirstCard();
        val transferPageFirstCard = dashboardPage.transferFirstCard();
        transferPageFirstCard.ClearingFields();
        val secondCard = DataHelper.getCardSecond();
        transferPageFirstCard.transferAmountFromSecondCard(amount1, secondCard);
        assertEquals(expected1, balancePageFirstCard + amount1);
        dashboardPage.ReturnDashboardPage();

        //перевод на 2 карту
        val balancePageSecondCard = dashboardPage.BalanceSecondCard();
        val transferPageSecondCard = dashboardPage.transferSecondCard();
        transferPageSecondCard.ClearingFields();
        val firstCard = DataHelper.getCardFirst();
        transferPageSecondCard.transferAmountFromFirstCard(amount2, firstCard);
        assertEquals(expected2, balancePageSecondCard + amount2);
        dashboardPage.ReturnDashboardPage();

    }
}