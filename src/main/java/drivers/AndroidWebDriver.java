package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidWebDriver implements WebDriverProvider {

    private final String hostName = System.getProperty("appium.host.name", "http://127.0.0.1:4723/wd/hub");
    private final long implicitlyWaitSecond = Integer.parseInt(System.getProperty("webdriver.timeouts.implicitlywait", "10"));
    private final String platformVersion = System.getProperty("platfrom.version", "7.0");

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName("Android");
        options.setDeviceName("otus");
        options.setPlatformVersion(platformVersion);
        //options.setApp(app.getAbsolutePath()); путь до apk в случае если приложение не установлено на устройстве

        options.setAppPackage("com.pyankoff.andy");
        options.setAppActivity(".MainActivity");

        try {
            WebDriver driver = new AndroidDriver(new URL(hostName), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWaitSecond));

            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
