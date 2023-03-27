package web.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.config.TestBase;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GifPageTest extends TestBase {

    @Test
    @Tag("giphy")
    @DisplayName("Проверка кнопки Share на странице гифки")
    @Epic("Релиз 1.0 UI")
    @Story("Развитие страницы гифки")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.CRITICAL)
    public void shareButtonTest() {
        step("Открытие страницы гифки", () -> {
            open(baseUrl);
        });

        step("Клик на первую в списке гифку", () -> {
            mainPage.openGifPage();
        });

        step("Клик на кнопку \"Share\"", () -> {
            gifPage.shareButtonClick();
        });

        step("Проверка: открылось модальное окно для копирования ссылки гифки", () -> {
            gifPage.verifyModalForCopyIsOpen();
        });

        step("Клик на кнопку \"Copy GIF Link\"", () -> {
            gifPage.copyButtonClick();
        });

        step("Проверка: текст \"Copy GIF Link\" изменился на \"Link Copied!\"", () -> {
            gifPage.verifySwitchTextOnCopyButton();
        });
    }

    @Test
    @Tag("giphy")
    @DisplayName("Проверка кнопок с тэгами под гифкой")
    @Epic("Релиз 1.0 UI")
    @Story("Развитие страницы гифки")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.NORMAL)
    public void tagButtonTest() {
        step("Открытие страницы гифки", () -> open(baseUrl));

        step("Клик на первую в списке гифку", () -> {
            mainPage.openGifPage();
        });

        step("Клик на первый тег", () -> {
            gifPage.tagButtonClick();
        });

        step("Проверка: открылась страница с гифками, найденными по тегу", () -> {
            gifPage.verifyHeaderOnTagSearchPage();
        });
    }
}
