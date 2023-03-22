package web.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class MainPageTest extends TestBase {

    @Test
    @Tag("giphy")
    @DisplayName("Проверка элементов верхнего меню")
    public void mainPageHeaderMenuElementsTest() {
        step("Открытие сайта", () -> {
            Selenide.open("https://giphy.com/");
        });

        step("Закрытие баннера \"Privacy Policy\"", () -> {
            $(".CloseButton-sc-ecivd4").click();
        });

        step("Проверка: в верхнем меню присутствуют все необходимые кнопки", () -> {
            $("#header").shouldHave(text("Reactions"),
                    text("Entertainment"), text("Sports"),
                    text("Stickers"), text("Artists"));
        });
    }

    @Test
    @Tag("giphy")
    @DisplayName("Проверка основных блоков на главной странице")
    public void mainPageHeadersOnPageTest() {
        step("Открытие сайта", () -> {
            Selenide.open("https://giphy.com/");
        });

        step("Закрытие баннера \"Privacy Policy\"", () -> {
            $(".CloseButton-sc-ecivd4").click();
        });

        step("Проверка: на главной странице присутствуют все основные блоки", () -> {
            $(".homepage__Container-sc-17e5hma-0").
                    shouldHave(text("Trending"), text("Artists"),
                            text("Clips"), text("Stories"));
        });
    }
}
