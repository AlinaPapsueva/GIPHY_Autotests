package web.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SupportPagesTest extends TestBase {

    @Test
    @Tag("giphy")
    @DisplayName("Проверка открытия Privacy Policy по клику на баннере")
    @Epic("Релиз 1.0")
    @Story("Развитие саппорт-страниц")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.CRITICAL)
    public void privacyPolicyOnBannerTest() {
        step("Открытие сайта", () -> open(baseUrl));

        step("Клик на ссылку \"Privacy Policy\" на баннере", () -> {
            privacyPolicyPage.bannerLinkClick();
        });

        step("Проверка: открылась страница \"Privacy Policy\"", () -> {
            privacyPolicyPage.verifyPageHeaderText();
        });
    }

    @Test
    @Tag("giphy")
    @DisplayName("Проверка открытия FAQ")
    @Epic("Релиз 1.0")
    @Story("Развитие саппорт-страниц")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.CRITICAL)
    public void openFaqTest() {
        step("Открытие сайта ", () -> open(baseUrl));

        step("Открытие страницы FAQ ", () -> {
            mainPage.closePrivacyPolicyBanner();
            mainPage.expandHeaderMenu();
            mainPage.openFaqPage();
        });

        step("Проверка: открылась страница FAQ ", () -> {
            faqPage.verifyPageTopicsHeaderText();
        });
    }
}
