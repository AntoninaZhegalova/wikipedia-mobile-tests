package drivers;

import com.codeborne.selenide.WebDriverProvider;
import credentials.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class, System.getProperties());
        String login = config.login();
        String password = config.password();
        String app = config.app();
        String device = config.device();
        String os_version = config.os_version();

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.user", login);
        mutableCapabilities.setCapability("browserstack.key", password);
        mutableCapabilities.setCapability("app", app);
        mutableCapabilities.setCapability("device", device);
        mutableCapabilities.setCapability("os_version", os_version);
        mutableCapabilities.setCapability("project", "Hometask-21");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "wikipedia_mobile_tests");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
