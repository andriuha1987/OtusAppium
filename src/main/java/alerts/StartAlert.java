package alerts;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;

public class StartAlert {

    public boolean isStartAlertPresent() {
        return $("[text='Must use physical device for Push Notifications']").has(Condition.visible);
    }

    public StartAlert clickOk() {
        $("[text='OK']").click();

        return this;
    }
}
