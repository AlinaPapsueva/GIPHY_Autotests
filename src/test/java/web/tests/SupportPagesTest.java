package web.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.config.TestBase;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SupportPagesTest extends TestBase {

    @Test
    @Tag("giphy_ui")
    @DisplayName("Проверка открытия Privacy Policy по клику на баннере")
    @Epic("Релиз 1.0 UI")
    @Story("Развитие саппорт-страниц")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.BLOCKER)
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
    @Tag("giphy_ui")
    @DisplayName("Проверка открытия FAQ")
    @Epic("Релиз 1.0 UI")
    @Story("Развитие саппорт-страниц")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.BLOCKER)
    public void openFaqTest() {
        step("Открытие сайта", () -> open(baseUrl));

        step("Закрытие баннера \"Privacy Policy\"", () -> {
            mainPage.closePrivacyPolicyBanner();
        });

        step("Открытие страницы FAQ в расширенном верхнем меню", () -> {
            mainPage.expandHeaderMenu();
            mainPage.openFaqPage();
        });

        step("Проверка: открылась страница FAQ ", () -> {
            faqPage.verifyPageTopicsHeaderText();
        });
    }
}
