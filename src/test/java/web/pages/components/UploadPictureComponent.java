package web.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class UploadPictureComponent {

    public void uploadPicture(String picture) {
        $$("h3").findBy(text("Sticker")).ancestor("div").$("input[type='file']").
                uploadFromClasspath(picture);
    }
}
