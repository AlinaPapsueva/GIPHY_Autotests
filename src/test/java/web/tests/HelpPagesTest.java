package web.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class HelpPagesTest extends TestBase {

    @Test
    @Tag("giphy")
    @DisplayName("Проверка открытия Privacy Policy по клику на баннере")
    public void privacyPolicyOnBannerTest() {
        step("Открытие сайта", () -> {
            Selenide.open("https://giphy.com/");
        });

        step("Клик на ссылку \"Privacy Policy\" на баннере", () -> {
            $(".Banner-sc-iopojr").$("[href='/privacy']").click();
        });

        step("Проверка: открылась страница \"Privacy Policy\"", () -> {
            $(".page-header").shouldHave(text("GIPHY Privacy Policy"));
        });
    }

    @Test
    @Tag("giphy")
    @DisplayName("Проверка открытия FAQ")
    public void openFaqTest() {
        step("Открытие сайта ", () -> {
            Selenide.open("https://giphy.com/");
        });

        step("Открытие страницы FAQ ", () -> {
            $(".CloseButton-sc-ecivd4").click();
            $(".EllipsisIcon-sc-1sn6bsk").click();
            $("[href='/faq']").click();
        });

        step("Проверка: открылась страница FAQ ", () -> {
            $(".homepage-container").shouldHave(text("Featured Help Topics"));
        });
    }
}
