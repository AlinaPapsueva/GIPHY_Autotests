package web.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class UserPageTest extends TestBase {

    @Test
    @Tag("giphy")
    @DisplayName("Проверка страницы пользователя @meganmotown")
    public void userPageTest() {
        step("Открытие страницы пользователя @meganmotown", () -> {
            Selenide.open("https://giphy.com/meganmotown");
        });

        step("Проверка: открыта страница пользователя @meganmotown", () -> {
            $(".HeaderSC-sc-1g0hdia").shouldHave(text("megan motown"));
        });

        step("Проверка: отображается корректный юзернейм @meganmotown", () -> {
            $("[href='/channel/meganmotown']").shouldHave(text("@meganmotown"));
        });

        step("Проверка: отображаются количество загруженных гифок и просмотров", () -> {
            $(".ChannelAnalyticsContainer-sc-9g2ivj").
                    shouldHave(text("GIF Uploads"), text("GIF Views"));
        });

//        step("Проверка: отображается текст в описании профиля юзера", () -> {
//        $(".Bio-sc-1dadwig").shouldHave(text("Top GIPHY Artist 3 Years Running"));
//        });

        step("Проверка: отображается ссылка на сайт юзера", () -> {
            $("[href='https://www.meganmotown.com']").shouldHave(text("www.meganmotown.com"));
        });

        step("Проверка: отображается ссылка на фейсбук юзера", () -> {
            $(".Container-sc-1mlrzqh").$("[name='facebook']").
                    shouldHave(attribute("href", "https://facebook.com/www.instagram.com/meganmotown"));
        });

        step("Проверка: отображается кнопка \"Связаться со мной\"", () -> {
            $(".HireMeButton-sc-h2ngct").shouldHave(text("Hire Me"));
        });
    }
}
