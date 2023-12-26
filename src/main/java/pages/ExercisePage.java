package pages;

import static com.codeborne.selenide.Selenide.$;

public class ExercisePage extends BasePage<ExercisePage> {

    public ChatPage clickStart() {
        $("[text='Start']").click();

        return new ChatPage();
    }
}
