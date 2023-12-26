package study;

import components.MainMenuComponent;
import data.MainMenuItemData;
import extensions.AndroidExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.ExercisePage;
import pages.StartPage;

@ExtendWith(AndroidExtension.class)
public class ExerciseWithChatCheckTest {

    @Test
    public void checkExercisePage() {
        new StartPage().open()
                .skipStartWelcome();

        /*
          Проверка, что при переходе в меню "Exercise" имеется текст "Learn 5 new words today"
          Далее при нажатии на кнопку "Start" происходит переход в чат
          Вводим текст OTUS и проверяем, что он введён
         */
        MainMenuComponent mainMenuComponent = new MainMenuComponent();
        ((ExercisePage) mainMenuComponent.clickMenu(MainMenuItemData.EXERCISE))
                .checkPageTextShouldBe("Learn 5 new words today")
                .clickStart()
                .checkChatIsOpened()
                .typeMsg("OTUS")
                .msgInChatTypeFieldIs("OTUS");
    }
}
