package api.tests;

import api.data.BaseTestData;
import api.data.SearchTestData;
import api.models.SearchBodyResponseModel;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static api.helpers.Endpoints.getGifsSearch;
import static api.spec.Specification.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {

    BaseTestData baseTestData = new BaseTestData();
    SearchTestData searchTestData = new SearchTestData();

    @Test
    @Tag("giphy_api")
    @DisplayName("Поиск по слову \"sticker\"")
    @Epic("Релиз 1.0 API")
    @Story("Настройка backend")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.NORMAL)
    void searchWordStickerTest() {
        step("Проверка: при поиске слова sticker идет выдача объектов с типом sticker", () -> {
            List<SearchBodyResponseModel> searchBodyResponseModel = given()
                    .spec(requestSpec)
                    .param("api_key", baseTestData.api_key)
                    .param("q", searchTestData.qSearchTextSticker)
                    .param("limit", searchTestData.limitFiveObjects)
                    .when()
                    .get(getGifsSearch)
                    .then()
                    .spec(responseSpec200)
                    .extract().body().jsonPath().getList("data", SearchBodyResponseModel.class);

            searchBodyResponseModel.forEach(x -> assertEquals(x.getType(), searchTestData.qSearchTextSticker));
        });
    }

    @Test
    @Tag("giphy_api")
    @DisplayName("Ошибка 414 при количестве символов более 50 в поисковом запросе")
    @Epic("Релиз 1.0 API")
    @Story("Настройка backend")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.NORMAL)
    void symbolsOverFiftyInSearch() {
        step("Проверка: при вводе отправке более 50 символов ожидается ошибка 414", () -> {
            given()
                    .spec(requestSpec)
                    .param("api_key", baseTestData.api_key)
                    .param("q", searchTestData.qLongTextForSearch)
                    .when()
                    .get(getGifsSearch)
                    .then()
                    .spec(responseSpec414);
        });
    }

    @Test
    @Tag("giphy_api")
    @DisplayName("Поиск без обязательного параметра \"q\"")
    @Epic("Релиз 1.0 API")
    @Story("Настройка backend")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.BLOCKER)
    void searchWithoutQueryParamQ() {
        step("Проверка: при отправке запроса без параметра \"q\" ожидается ошибка 400", () -> {
            given()
                    .spec(requestSpec)
                    .param("api_key", baseTestData.api_key)
                    .when()
                    .get(getGifsSearch)
                    .then()
                    .spec(responseSpec400);
        });
    }

    @Test
    @Tag("giphy_api")
    @DisplayName("Поиск без обязательного параметра \"api_key\"")
    @Epic("Релиз 1.0 API")
    @Story("Настройка backend")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.BLOCKER)
    void searchWithoutQueryParamApiKey() {
        step("Проверка: при отправке запроса без параметра \"api_key\" ожидается ошибка 401", () -> {
            given()
                    .spec(requestSpec)
                    .when()
                    .get(getGifsSearch)
                    .then()
                    .spec(responseSpec401);
        });
    }
}

