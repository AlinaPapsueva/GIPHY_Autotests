package web.pages.gifPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GifPage {

    TestDataGifPage testDataGifPage = new TestDataGifPage();

    private final String SUCCESS_COPY_TEXT = "Link Copied!";
    private final String COPY_BUTTON_TEXT = "Copy GIF Link";
    private final String H1_TAG_SEARCH_PAGE_TEXT = "Explore";

    private SelenideElement
            shareButton = $(withTagAndText("span", "Share")),
            h1ExploreOnTagSearchPage = $("#content h1"),
            copyButton = $(".CopyWrapper-sc-6y8nbc").$("button"),
            userName = $(".PublicUserDiv-sc-6zak0l"),
            tagButton = $(".TagsContainer-sc-1i1183u");
    private ElementsCollection
            tagButtonsCollection = $$(".TagsContainer-sc-1i1183u .Container-sc-1xevvej a");

    public GifPage shareButtonClick() {
        shareButton.click();

        return this;
    }

    public GifPage copyButtonClick() {
        copyButton.click();

        return this;
    }

    public GifPage tagButtonClick() {
        tagButtonsCollection.get(0).click();

        return this;
    }

    public GifPage verifyModalForCopyIsOpen() {
        copyButton.
                shouldBe(visible).
                shouldHave(text(COPY_BUTTON_TEXT));

        return this;
    }

    public GifPage verifySwitchTextOnCopyButton() {
        copyButton.
                shouldHave(text(SUCCESS_COPY_TEXT));

        return this;
    }

    public GifPage verifyHeaderOnTagSearchPage() {
        h1ExploreOnTagSearchPage.
                shouldHave(text(H1_TAG_SEARCH_PAGE_TEXT));

        return this;
    }

    public GifPage verifyUserNameInGifPage() {
        userName.shouldHave(text(testDataGifPage.userName));

        return this;
    }

    public GifPage verifyTagNameInGifPage() {
        tagButton.shouldHave(text(testDataGifPage.tagText));

        return this;
    }
}
