package ru.netologi.page;

import com.codeborne.selenide.SelenideElement;
import ru.netologi.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    private SelenideElement fieldAmount = $("[data-test-id=amount] input");
    private SelenideElement fieldFrom = $("[data-test-id=from] input");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");

    public TransferPage() {}
        public void transferCard(DataHelper.CardInfo CardInfo, String amount) {
            fieldAmount.setValue(String.valueOf(amount));
            fieldFrom.setValue(CardInfo.getCardNumber());
            transferButton.click();
            new DashboardPage();
        }

        public void getError() {
            $(byText("Недостаточно средств для перевода!")).shouldBe(visible);
        }
    }


