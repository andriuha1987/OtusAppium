package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import data.ShareFreeLessonsType;

public class GrammarPage extends BasePage<GrammarPage> {

    public GrammarPage clickFreeLessons() {
        $("[text*='Get free lessons']").click();

        return this;
    }

    public GrammarPage shareTypeIsExists(ShareFreeLessonsType shareFreeLessonsType) {
        $(String.format("[class-name='android.widget.TextView'][text='%s']", '\t' + shareFreeLessonsType.getName())).shouldBe(Condition.exist);

        return this;
    }
}
