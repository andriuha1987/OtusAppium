package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

public abstract class BasePage<T> {

    public T open() {
        Selenide.open();

        return (T) this;
    }

    public T checkPageTextShouldBe(String text) {
        $(String.format("[text='%s']", text)).should(Condition.visible);

        return (T) this;
    }

    public T clickButton(String buttonName) {
        $(String.format("[text='%s']", buttonName)).click();

        return (T) this;
    }
}
