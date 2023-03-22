package web.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class CreateStickerTest extends TestBase {

    @Test
    @Tag("giphy")
    @DisplayName("Проверка попытки создания стикера без авторизации на сайте")
    public void createStickerWithoutLoginTest() {
        step("Открытие страницы создания стикеров", () -> {
            Selenide.open("https://giphy.com");
            $("[href='/create/gifmaker']").click();
        });

        step("Попытка загрузки картинки для создания стикера", () -> {
            $$("h3").findBy(text("Sticker")).ancestor("div").$("input[type='file']").
                    uploadFromClasspath("images/cat.jpg");
        });

        step("Проверка: чтобы создать стикер, необходимо залогиниться на сайте", () -> {
            $(".modal__Container-sc-zyc6ci-0").
                    shouldBe(visible).
                    shouldHave(text("You've gotta log in to upload to GIPHY!"));
        });
    }
}
