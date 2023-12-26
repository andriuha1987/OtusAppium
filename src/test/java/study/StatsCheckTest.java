package study;

import components.MainMenuComponent;
import data.MainMenuItemData;
import extensions.AndroidExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import pages.StartPage;
import pages.StatsPage;
import org.junit.jupiter.api.Assertions;

@ExtendWith(AndroidExtension.class)
public class StatsCheckTest {

    @Test
    public void checkStatsPage() {
        new StartPage().open()
                .skipStartWelcome();

        /*
         Во вкладке Stats
         Статистика - сколько WORDS WRITTEN изучено и это будет числом
         Аналогично для GRAMMAR LESSONS TAKEN и WORDS IN VOCABULARY
         Для CURRENT STREAK и MAXIMUM STREAK что они нне пустые
        */
        MainMenuComponent mainMenuComponent = new MainMenuComponent();
        StatsPage statsPage = ((StatsPage) mainMenuComponent.clickMenu(MainMenuItemData.STATS));
        statsPage.waitLoadStats();

        Assertions.assertTrue(statsPage.getWordsWritten().matches("\\d+"),"Поле 'WORDS WRITTEN' не является положительным числом");

        Assertions.assertFalse(statsPage.getMaximumStreak().isEmpty(),"Поле 'MAXIMUM STREAK' пусто");
        Assertions.assertFalse(statsPage.getCurrentStreak().isEmpty(),"Поле 'CURRENT STREAK' пусто");

        Assertions.assertTrue(statsPage.getGrammarLessonsTaken().matches("\\d+"),"Поле 'GRAMMAR LESSONS TAKEN' не является положительным числом");
        Assertions.assertTrue(statsPage.getWordsInVocabulary().matches("\\d+"),"Поле 'WORDS IN VOCABULARY' не является положительным числом");

    }
}
