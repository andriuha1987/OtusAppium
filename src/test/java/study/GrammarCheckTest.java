package study;

import components.MainMenuComponent;
import data.MainMenuItemData;
import data.ShareFreeLessonsType;
import extensions.AndroidExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.GrammarPage;
import pages.StartPage;

@ExtendWith(AndroidExtension.class)
public class GrammarCheckTest {

    @Test
    public void checkGrammarPage() {
        new StartPage().open()
                .skipStartWelcome();

        /*
        Во вкладке Grammar можно выбрать пункт 'Get free lessons' и получить на выбор несколько способов поделиться
        */
        MainMenuComponent mainMenuComponent = new MainMenuComponent();
        GrammarPage grammarPage = ((GrammarPage) mainMenuComponent.clickMenu(MainMenuItemData.GRAMMAR));

        grammarPage
                .clickFreeLessons()
                .clickButton("Share")
                .shareTypeIsExists(ShareFreeLessonsType.COPY)
                .shareTypeIsExists(ShareFreeLessonsType.GMAIL)
                .shareTypeIsExists(ShareFreeLessonsType.COPY_TO_CLIPBOARD)
                .shareTypeIsExists(ShareFreeLessonsType.HANGOUTS)
                .shareTypeIsExists(ShareFreeLessonsType.MESSENGER);

    }
}
