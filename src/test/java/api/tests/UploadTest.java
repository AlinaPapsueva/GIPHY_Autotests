package api.tests;

import api.data.BaseTestData;
import api.data.UploadTestData;
import api.models.UploadModel;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.helpers.Endpoints.postGifsSearch;
import static api.spec.Specification.requestSpecUpload;
import static api.spec.Specification.responseSpec200;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class UploadTest {

    BaseTestData baseTestData = new BaseTestData();
    UploadTestData uploadTestData = new UploadTestData();

    @Test
    @Tag("giphy_api")
    @DisplayName("Загрузка гифки")
    @Epic("Релиз 1.0 API")
    @Story("Настройка backend")
    @Owner("Алина Папсуева")
    @Severity(SeverityLevel.CRITICAL)
    void uploadGif() {
        step("Проверка: успешная загрузка гифки с ответом 200", () -> {
            UploadModel upload = new UploadModel();
            upload.setApi_key(baseTestData.api_key);
            upload.setSource_image_url(uploadTestData.imageLink);

            given()
                    .spec(requestSpecUpload)
                    .body(upload)
                    .when()
                    .post(postGifsSearch)
                    .then()
                    .spec(responseSpec200);
        });
    }
}
