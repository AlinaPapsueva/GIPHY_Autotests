package web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FaqPage {

    private final String FAQ_TOPICS_HEADER = "Featured Help Topics";
    private SelenideElement
            pageTopicsHeader = $(".homepage-container");

    public FaqPage verifyPageTopicsHeaderText() {
        pageTopicsHeader.shouldHave(text(FAQ_TOPICS_HEADER));

        return this;
    }
}
