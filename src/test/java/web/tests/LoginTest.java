package web.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.config.TestBase;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LoginTest extends TestBase {

    @Test
    @Tag("giphy")
    @DisplayName("Проверка логина с рандомными значениями")
    @Epic("Релиз 1.0 UI")
    @Story("Логин пользователя")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.BLOCKER)
    public void logInWithFakeDataTest() {
        step("Открытие сайта", () -> open(baseUrl));

        step("Закрытие баннера \"Privacy Policy\"", () -> {
            mainPage.closePrivacyPolicyBanner();
        });

        step("Переход на страницу логина", () -> {
            mainPage.openLoginPage();
        });

        step("Ввод данных в поля email и password рандомных значений", () -> {
            loginPage.setValueEmailInput();
            loginPage.setValuePasswordInput();
        });

        step("Клик на кнопку \"Log in\"", () -> {
            loginPage.clickLoginButton();
        });

        step("Проверка: появилась ошибка о некорректных данных", () -> {
            loginPage.verifyLoginErrorText();
        });
    }
}
