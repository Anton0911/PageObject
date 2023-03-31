package ru.netologi.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.impl.Html.text;

public class DashboardPage {
    private final SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement oneCards = $$(".list__item div").first();
    private SelenideElement  twoCards = $$(".list__item div").last();
    private final SelenideElement oneCardButton = $$("[data-test-id=action-deposit]").first();
    private final SelenideElement twoCardButton = $$("[data-test-id=action-deposit]").last();
    private final SelenideElement reload = $("[data-test-id=action-reload]");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage(){
        heading.shouldBe(visible, Duration.ofSeconds(10));
    }

    public int getOneCardBalance() {
        val text = oneCards.text();
        return extractBalanceOneCards(text);
    }

    private int extractBalanceOneCards(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
    public int getTwoCardBalance() {
        val text = twoCards.text();
        return extractBalanceTwoCards(text);
    }

    private int extractBalanceTwoCards(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
    public TransferPage oneCardButton() {
        oneCardButton.click();
        return new TransferPage();
    }

    public TransferPage twoCardButton() {
        twoCardButton.click();
        return new TransferPage();
    }

}

