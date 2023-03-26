package web.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/configurations/webTests/${env}.properties"
})

public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("size")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("version")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("pageLoadStrategy")
    String getPageLoadStrategy();

}
