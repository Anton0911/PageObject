package ru.netologi.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netologi.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id='code'] input");
    private SelenideElement verifyButton = $("[data-test-id='action-verify']");

    public VerificationPage(){
        codeField.should(Condition.visible);
    }
    public DashboardPage validVerify(DataHelper.ValidetionCode validetionCode){
      codeField.setValue(validetionCode.getCode());
      verifyButton.click();
      return new DashboardPage();
    }
}
