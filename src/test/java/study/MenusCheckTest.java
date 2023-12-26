package study;

import components.MainMenuComponent;
import data.MainMenuItemData;
import extensions.AndroidExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.StartPage;

@ExtendWith(AndroidExtension.class)
public class MenusCheckTest {

    @Test
    public void openMainPage() {
        new StartPage().open()
                .skipStartWelcome();

        new MainMenuComponent()
                .mainMenuItemVisible(MainMenuItemData.CHAT)
                .mainMenuItemVisible(MainMenuItemData.EXERCISE)
                .mainMenuItemVisible(MainMenuItemData.GRAMMAR)
                .mainMenuItemVisible(MainMenuItemData.STATS);

    }
}
