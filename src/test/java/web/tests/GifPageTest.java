package web.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class GifPageTest extends TestBase {

    @Test
    @Tag("giphy")
    @DisplayName("Проверка кнопки Share на странице гифки")
    public void shareButtonTest() {
        step("Открытие страницы гифки", () -> {
            Selenide.open("https://giphy.com/");
            $(".giphy-gif").click();
        });

        step("Клик на кнопку \"Share\"", () -> {
            $(withTagAndText("span", "Share")).click();
        });

        step("Проверка: открылось модальное окно для копирования ссылки гифки", () -> {
            $(".CopyWrapper-sc-6y8nbc").
                    shouldBe(visible).
                    shouldHave(text("Copy GIF Link"));
        });

        step("Клик на кнопку \"Copy GIF Link\"", () -> {
            $(".CopyWrapper-sc-6y8nbc").click();
        });

        step("Проверка: текст \"Copy GIF Link\" изменился на \"Link Copied!\"", () -> {
            $(".CopyWrapper-sc-6y8nbc").$("button").
                    shouldHave(text("Link Copied!"));
        });
    }

    @Test
    @Tag("giphy")
    @DisplayName("Проверка кнопок с тэгами под гифкой")
    public void tagButtonTest() {
        step("Открытие страницы гифки", () -> {
            Selenide.open("https://giphy.com/");
            $(".giphy-gif").click();
        });

        step("Клик на первый тег", () -> {
            $$(".TagsContainer-sc-1i1183u .Container-sc-1xevvej a").get(0).click();
        });

        step("Проверка: открылась страница с гифками, найденными по тегу", () -> {
            $("#content h1").shouldHave(text("Explore"));
        });
    }
}
