package ru.netology.bdd.data;

import lombok.Value;

public class DataHelper {

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }
    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }
    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardFirst {
        private String cardFirstNumber;
        private String cardFirstNumberHidden;
    }
    public static CardFirst getCardFirst() {
        return new CardFirst("5559000000000001", "**** **** **** 0001");
    }

    @Value
    public static class CardSecond {
        private String cardSecondNumber;
        private String cardSecondNumberHidden;
    }
    public static CardSecond getCardSecond() {
        return new CardSecond("5559000000000002","**** **** **** 0002");
    }
}