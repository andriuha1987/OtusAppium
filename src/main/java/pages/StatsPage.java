package pages;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class StatsPage extends BasePage<StatsPage> {

    public StatsPage waitLoadStats() {
        $(By.xpath("//android.widget.TextView[@text=\"WORDS WRITTEN\"]/preceding-sibling::android.widget.TextView"))
                .shouldHave(matchText("\\S+"));

        return this;
    }

    public String getWordsWritten() {
        return getTextUpFromLabel("WORDS WRITTEN");
    }

    public String getMaximumStreak() {
        return getTextUpFromLabel("MAXIMUM STREAK");
    }

    public String getCurrentStreak() {
        return getTextUpFromLabel("CURRENT STREAK");
    }

    public String getGrammarLessonsTaken() {
        return getTextUpFromLabel("GRAMMAR LESSONS TAKEN");
    }

    public String getWordsInVocabulary() {
        return getTextUpFromLabel("WORDS IN VOCABULARY");
    }

    public String getTextUpFromLabel(String labelText) {
        return $(By.xpath("//android.widget.TextView[@text=\"" + labelText + "\"]/preceding-sibling::android.widget.TextView")).text();
    }

}
