package web.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverProvider {

    private WebDriverConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        createWebDriver();
    }

    private void createWebDriver() {
        switch (config.getBrowser().toLowerCase()) {
            case "chrome":
                Configuration.browser = "chrome";
                break;
            case "edge":
                Configuration.browser = "edge";
                break;
            case "opera":
                Configuration.browser = "opera";
                break;
            default:
                throw new RuntimeException(config.getBrowser());
        }

        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.remote = config.getRemoteUrl();
        Configuration.pageLoadStrategy = config.getPageLoadStrategy();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
    }
}