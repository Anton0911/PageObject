package ru.netologi.data;

import lombok.Value;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

public class DataHelper {
    private DataHelper(){}

    @Value
    public static class AutInfo {
       private String login;
        private String password;
    }
    public static AutInfo getValideteAutInfo(){
        return new AutInfo("vasya", "qwerty123");
    }
    public static AutInfo getNoValideteAutInfo(AutInfo fake){
        return new AutInfo("pety", "123qwerty");
    }
    @Value
    public static class ValidetionCode {
        private String code;
    }
    public static ValidetionCode getValidetionCode(AutInfo autInfo){
        return new ValidetionCode("12345");
    }
    @Value
    public static class CardInfo{
        private String cardNumber;
        public String cardBalance;
    }


    public static CardInfo getOneCardInfo() {

        return new CardInfo("5559000000000001", "10000");
    }


    public static CardInfo getTwoCardInfo() {

        return new CardInfo("5559000000000002", "10000");
    }


    public static int getBalanceOneCardAfterTransfer(int balance, int amount) {

        return balance - amount;
    }


    public static int getBalanceTwoCardAfterTransfer(int balance, int amount) {

        return balance + amount;
    }
}
