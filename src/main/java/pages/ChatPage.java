package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;

public class ChatPage extends BasePage<ChatPage> {
    private String initCssSelectorTypeElement = "[class-name='android.widget.EditText'][text='Type a message...']";

    public ChatPage checkChatIsOpened() {
        $(initCssSelectorTypeElement).shouldBe(Condition.visible);

        return this;
    }

    public ChatPage typeMsg(String text) {
        $(initCssSelectorTypeElement).sendKeys(text);

        return this;
    }

    public ChatPage msgInChatTypeFieldIs(String expectedText) {
        $(String.format("[class-name='android.widget.EditText'][text='%s']", expectedText)).shouldBe(Condition.visible);

        return this;
    }
}
