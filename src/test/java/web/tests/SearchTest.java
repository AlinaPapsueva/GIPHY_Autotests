package web.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.config.TestBase;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchTest extends TestBase {

    @Test
    @Tag("giphy_ui")
    @DisplayName("Проверка поиска по @user + tag")
    @Epic("Релиз 1.0 UI")
    @Story("Развитие поиска")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.CRITICAL)
    public void searchUserPlusTagTest() {
        step("Открытие сайта", () -> open(baseUrl));

        step("Поиск @user + tag через поисковую строку", () -> {
            mainPage.setValueInSearchInputAndPressEnter();
        });

        step("Открытие первой гифки в списке найденных", () -> {
            searchResultPage.openFirstGifCard();
        });

        step("Проверка: на странице гифки указан искомый юзер", () -> {
            gifPage.verifyUserNameInGifPage();
        });

        step("Проверка: на странице гифки присутствует искомый тег", () -> {
            gifPage.verifyTagNameInGifPage();
        });
    }
}
