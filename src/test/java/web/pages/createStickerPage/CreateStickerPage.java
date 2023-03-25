package web.pages.createStickerPage;

import com.codeborne.selenide.SelenideElement;
import web.pages.components.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CreateStickerPage {

    UploadPictureComponent uploadPictureComponent = new UploadPictureComponent();

    private final String ERROR_TEXT = "You've gotta log in to upload to GIPHY!";

    private SelenideElement
            errorModal = $(".modal__Container-sc-zyc6ci-0");

    public CreateStickerPage setPicture(String picture) {
        uploadPictureComponent.uploadPicture(picture);

        return this;
    }

    public CreateStickerPage verifyResult() {
        errorModal.
                shouldBe(visible).
                shouldHave(text(ERROR_TEXT));

        return this;
    }
}
