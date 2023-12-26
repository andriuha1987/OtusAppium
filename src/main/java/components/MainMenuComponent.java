package components;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import data.MainMenuItemData;
import pages.*;

public class MainMenuComponent {

    public MainMenuComponent mainMenuItemVisible(MainMenuItemData mainMenuItemData) {
        $(String.format("[text='%s']", mainMenuItemData.getName())).shouldBe(Condition.visible);

        return this;
    }

    public BasePage<? extends BasePage<?>> clickMenu(MainMenuItemData mainMenuItemData) {
        $(String.format("[text='%s']", mainMenuItemData.getName())).click();

        switch (mainMenuItemData) {
            case CHAT:
                return new ChatPage();
            case EXERCISE:
                return new ExercisePage();
            case GRAMMAR:
                return new GrammarPage();
            case STATS:
                return new StatsPage();
            default:
                throw new RuntimeException(String.format("Unsupported Menu Item - %s", mainMenuItemData.getName()));
        }
    }
}
