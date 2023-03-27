package web.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.config.TestBase;

import static io.qameta.allure.Allure.step;

public class UserPageTest extends TestBase {

    @Test
    @Tag("giphy")
    @DisplayName("Проверка страницы пользователя")
    @Epic("Релиз 1.0 UI")
    @Story("Развитие страницы пользователя")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.CRITICAL)
    public void userPageTest() {
        step("Открытие страницы пользователя", () -> {
            userPage.openUserPage();
        });

        step("Проверка: открыта страница пользователя", () -> {
            userPage.verifyUserName();
        });

        step("Проверка: отображается корректный юзернейм", () -> {
            userPage.verifyChannelName();
        });

        step("Проверка: отображаются количество загруженных гифок и просмотров", () -> {
            userPage.verifyAnalyticsBlock();
        });

        step("Проверка: отображается ссылка на сайт пользователя", () -> {
            userPage.verifyUserSiteLink();
        });

        step("Проверка: отображается ссылка на фейсбук пользователя", () -> {
            userPage.verifyUserFacebookLink();
        });

        step("Проверка: отображается кнопка \"Связаться со мной\"", () -> {
            userPage.verifyHireMeButton();
        });
    }
}
