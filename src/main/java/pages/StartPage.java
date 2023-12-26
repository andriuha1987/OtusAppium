package pages;

import static com.codeborne.selenide.Selenide.$;

import alerts.StartAlert;
import com.codeborne.selenide.Condition;

public class StartPage extends BasePage<StartPage> {

    public StartPage clickNext() {
        $("[text='Next']").click();

        return this;
    }

    public MainPage clickSkip() {
        $("[text='Skip >']").click();

        return new MainPage();
    }

    public boolean isStartPageOpened() {
        return $("[text='Next']").has(Condition.visible);
    }

    public MainPage skipStartWelcome() {
        if (isStartPageOpened()) {
            this
                    .checkPageTextShouldBe("Chat to improve your English")
                    .clickNext()
                    .checkPageTextShouldBe("Learn new words and grammar")
                    .clickNext()
                    .checkPageTextShouldBe("7 days FREE")
                    .clickSkip();
        }

        StartAlert startAlert = new StartAlert();
        if (startAlert.isStartAlertPresent()) {
            startAlert.clickOk();
        }

        return new MainPage();
    }
}
