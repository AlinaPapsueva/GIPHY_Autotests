package web.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import web.config.WebDriverProvider;
import web.helpers.Attach;
import web.pages.FaqPage;
import web.pages.PrivacyPolicyPage;
import web.pages.SearchResultPage;
import web.pages.createStickerPage.CreateStickerPage;
import web.pages.gifPage.GifPage;
import web.pages.loginPage.LoginPage;
import web.pages.mainPage.MainPage;
import web.pages.userPage.UserPage;

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
        WebDriverProvider provider = new WebDriverProvider();
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
