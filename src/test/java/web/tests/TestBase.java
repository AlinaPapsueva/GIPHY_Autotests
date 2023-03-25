package web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import web.helpers.Attach;
import web.pages.*;
import web.pages.createStickerPage.CreateStickerPage;
import web.pages.FaqPage;
import web.pages.gifPage.GifPage;
import web.pages.loginPage.LoginPage;
import web.pages.mainPage.MainPage;
import web.pages.userPage.UserPage;

import java.util.Map;

public class TestBase {

    MainPage mainPage = new MainPage();
    GifPage gifPage = new GifPage();
    FaqPage faqPage = new FaqPage();
    UserPage userPage = new UserPage();
    LoginPage loginPage = new LoginPage();
    CreateStickerPage createStickerPage = new CreateStickerPage();
    PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage();
    SearchResultPage searchResultPage = new SearchResultPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://giphy.com";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
//        Configuration.remote = System.getProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,  // включает режим окошко_в_окошке
                "enableVideo", true         // включает запись видео
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @AfterEach
    void closeWindow() {
        Selenide.closeWindow();
    }
}
