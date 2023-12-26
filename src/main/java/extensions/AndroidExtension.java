package extensions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.AndroidWebDriver;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

@SuppressFBWarnings(value = {"ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD"})
public class AndroidExtension implements BeforeAllCallback, AfterAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        Configuration.browserSize = null;
        Configuration.browser = AndroidWebDriver.class.getName();
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) {
        Selenide.closeWebDriver();
    }
}
