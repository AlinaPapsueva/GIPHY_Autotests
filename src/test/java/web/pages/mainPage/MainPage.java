package web.pages.mainPage;

import com.codeborne.selenide.SelenideElement;
import web.pages.userPage.UserPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    TestDataMainPage testDataMainPage = new TestDataMainPage();

    private final String REACTIONS_BUTTON = "Reactions";
    private final String ENTERTAINMENT_BUTTON = "Entertainment";
    private final String SPORTS_BUTTON = "Sports";
    private final String STICKERS_BUTTON = "Stickers";
    private final String ARTISTS_BUTTON = "Artists";
    private final String UPLOAD_BUTTON = "Upload";
    private final String CREATE_BUTTON = "Create";
    private final String LOGIN_BUTTON = "Log in";
    private final String TRENDING_BLOCK_HEADER = "Trending";
    private final String ARTISTS_BLOCK_HEADER = "Artists";
    private final String CLIPS_BLOCK_HEADER = "Clips";
    private final String STORIES_BLOCK_HEADER = "Stories";

    private SelenideElement
            createButton = $("[href='/create/gifmaker']"),
            gifCard = $(".giphy-gif"),
            closePrivacyPolicyBannerButton = $(".CloseButton-sc-ecivd4"),
            expandHeaderMenuButton = $(".EllipsisIcon-sc-1sn6bsk"),
            faqButton = $("[href='/faq']"),
            loginButton = $("[href='/login']"),
            headerMenu = $("#header"),
            mainPageContainer = $(".homepage__Container-sc-17e5hma-0"),
            searchInput = $("input");

    public MainPage clickCreateButton() {
        createButton.click();

        return this;
    }

    public MainPage openGifPage() {
        gifCard.click();

        return this;
    }

    public MainPage closePrivacyPolicyBanner() {
        closePrivacyPolicyBannerButton.click();

        return this;
    }

    public MainPage expandHeaderMenu() {
        expandHeaderMenuButton.click();

        return this;
    }

    public MainPage openFaqPage() {
        faqButton.click();

        return this;
    }

    public MainPage openLoginPage() {
        loginButton.click();

        return this;
    }

    public MainPage setValueInSearchInputAndPressEnter() {
        searchInput.setValue(testDataMainPage.searchUserAndTagText).pressEnter();

        return this;
    }

    public MainPage verifyHeaderMenuButtons() {
        headerMenu.shouldHave(text(REACTIONS_BUTTON),
                text(ENTERTAINMENT_BUTTON), text(SPORTS_BUTTON),
                text(STICKERS_BUTTON), text(ARTISTS_BUTTON),
                text(UPLOAD_BUTTON), text(CREATE_BUTTON), text(LOGIN_BUTTON));

        return this;
    }

    public MainPage verifyBlockHeadersOnPage() {
        mainPageContainer.shouldHave(text(TRENDING_BLOCK_HEADER),
                text(ARTISTS_BLOCK_HEADER), text(CLIPS_BLOCK_HEADER),
                text(STORIES_BLOCK_HEADER));

        return this;
    }
}
