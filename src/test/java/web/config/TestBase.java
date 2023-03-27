package web.config;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

    public MainPage mainPage = new MainPage();
    public GifPage gifPage = new GifPage();
    public FaqPage faqPage = new FaqPage();
    public UserPage userPage = new UserPage();
    public LoginPage loginPage = new LoginPage();
    public CreateStickerPage createStickerPage = new CreateStickerPage();
    public PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage();
    public SearchResultPage searchResultPage = new SearchResultPage();

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
