package api.tests;

import api.data.BaseTestData;
import api.data.GetGifByIdTestData;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.helpers.Endpoints.getGifs;
import static api.spec.Specification.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetGifByIdTest {

    BaseTestData baseTestData = new BaseTestData();
    GetGifByIdTestData getGifByIdTestData = new GetGifByIdTestData();

    @Test
    @Tag("giphy_api")
    @DisplayName("Поиск гифки по корректному ID")
    @Epic("Релиз 1.0 API")
    @Story("Настройка backend")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.CRITICAL)
    void getGifWithCorrectId() {
        step("Проверка: при добавлении корректного ID к эндпоинту в ответ приходит соответсвующая ему гифка", () -> {
            Response response = given()
                    .spec(requestSpec)
                    .param("api_key", baseTestData.api_key)
                    .when()
                    .get(getGifs + getGifByIdTestData.gifIdCorrect)
                    .then()
                    .spec(responseSpec200)
                    .extract().response();

            JsonPath jsonPath = response.jsonPath();
            Object id = jsonPath.get("data.id");
            assertEquals(id, getGifByIdTestData.gifIdCorrect);
        });
    }

    @Test
    @Tag("giphy_api")
    @DisplayName("Поиск гифки по НЕкорректному ID")
    @Epic("Релиз 1.0 API")
    @Story("Настройка backend")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.CRITICAL)
    void getGifWithIncorrectId() {
        step("Проверка: при добавлении корректного ID к эндпоинту в ответ приходит соответсвующая ему гифка", () -> {
            given()
                    .spec(requestSpec)
                    .param("api_key", baseTestData.api_key)
                    .when()
                    .get(getGifs + getGifByIdTestData.gifIdIncorrect)
                    .then()
                    .spec(responseSpec404);
        });
    }
}
