package web.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPageTest extends TestBase {

    @Test
    @Tag("giphy")
    @DisplayName("Проверка элементов верхнего меню")
    @Epic("Релиз 1.0")
    @Story("Развитие главной страницы")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.CRITICAL)
    public void mainPageHeaderMenuElementsTest() {
        step("Открытие сайта", () -> open(baseUrl));

        step("Закрытие баннера \"Privacy Policy\"", () -> {
            mainPage.closePrivacyPolicyBanner();
        });

        step("Проверка: в верхнем меню присутствуют все необходимые кнопки", () -> {
            mainPage.verifyHeaderMenuButtons();
        });
    }

    @Test
    @Tag("giphy")
    @DisplayName("Проверка основных блоков на главной странице")
    @Epic("Релиз 1.0")
    @Story("Развитие главной страницы")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.CRITICAL)
    public void mainPageHeadersOnPageTest() {
        step("Открытие сайта", () -> open(baseUrl));

        step("Закрытие баннера \"Privacy Policy\"", () -> {
            mainPage.closePrivacyPolicyBanner();
        });

        step("Проверка: на главной странице присутствуют все основные блоки", () -> {
            mainPage.verifyBlockHeadersOnPage();
        });
    }
}
