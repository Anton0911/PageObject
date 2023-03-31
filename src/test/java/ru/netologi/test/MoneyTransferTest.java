package ru.netologi.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netologi.data.DataHelper;
import ru.netologi.page.DashboardPage;
import ru.netologi.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferTest {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var autInfo = DataHelper.getValideteAutInfo();
        var verificationPage = loginPage.validlogin(autInfo);
        var verificationCode = DataHelper.getValidetionCode(autInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    void shouldTransferOneToTwoCard() {
        var dashboardPage = new DashboardPage();
        int balanceOneCard = dashboardPage.getOneCardBalance();
        int balanceTwoCard = dashboardPage.getTwoCardBalance();
        var transferPage = dashboardPage.twoCardButton();
        var infoCard = DataHelper.getOneCardInfo();
        String amount = "300";
        transferPage.transferCard(infoCard, amount);
        assertEquals(balanceOneCard - Integer.parseInt(amount), dashboardPage.getOneCardBalance());
        assertEquals(balanceTwoCard + Integer.parseInt(amount), dashboardPage.getTwoCardBalance());

    }
    @Test
    void shouldTransferTwoToOneCard() {
        var dashboardPage = new DashboardPage();
        int balanceOneCard = dashboardPage.getOneCardBalance();
        int balanceTwoCard = dashboardPage.getTwoCardBalance();
        var transferPage = dashboardPage.oneCardButton();
        var infoCard = DataHelper.getTwoCardInfo();
        String amount = "300";
        transferPage.transferCard(infoCard, amount);
        assertEquals(balanceOneCard + Integer.parseInt(amount), dashboardPage.getOneCardBalance());
        assertEquals(balanceTwoCard - Integer.parseInt(amount), dashboardPage.getTwoCardBalance());

    }
}
