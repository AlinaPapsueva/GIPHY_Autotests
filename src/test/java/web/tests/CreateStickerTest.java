package web.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.config.TestBase;
import web.pages.createStickerPage.TestDataCreateStickerPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CreateStickerTest extends TestBase {

    TestDataCreateStickerPage testDataCreateStickerPage = new TestDataCreateStickerPage();

    @Test
    @Tag("giphy_ui")
    @DisplayName("Проверка попытки создания стикера без авторизации на сайте")
    @Epic("Релиз 1.0 UI")
    @Story("Создание стикеров")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.BLOCKER)
    public void createStickerWithoutLoginTest() {
        step("Открытие сайта", () -> open(baseUrl));

        step("Клик на кнопку Create", () -> {
            mainPage.clickCreateButton();
        });

        step("Попытка загрузки картинки для создания стикера", () -> {
            createStickerPage.setPicture(testDataCreateStickerPage.picture);
        });

        step("Проверка: чтобы создать стикер, необходимо залогиниться на сайте", () -> {
            createStickerPage.verifyResult();
        });
    }
}
