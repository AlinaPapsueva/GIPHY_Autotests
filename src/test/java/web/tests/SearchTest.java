package web.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SearchTest extends TestBase {

    @Test
    @Tag("giphy")
    @DisplayName("Проверка поиска по @user + tag")
    public void searchUserPlusTagTest() {
        step("Открытие сайта", () -> {
            Selenide.open("https://giphy.com/");
        });

        step("Поиск @meganmotown + cat через поисковую строку", () -> {
            $("input").setValue("@meganmotown cat").pressEnter();
        });

        step("Открытие первой гифки в списке найденных", () -> {
            $(".giphy-grid a").click();
        });

        step("Проверка: на странице гифки указан искомый юзер", () -> {
            $(".PublicUserDiv-sc-6zak0l").shouldHave(text("megan motown"));
        });

        step("Проверка: на странице гифки присутствует искомый тег", () -> {
            $(".TagsContainer-sc-1i1183u").shouldHave(text("#cat"));
        });
    }
}
