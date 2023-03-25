package web.pages.userPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UserPage {

    TestDataUserPage testDataUserPage = new TestDataUserPage();

    private final String GIF_UPLOADS_SUBTEXT = "GIF Uploads";
    private final String GIF_VIEWS_SUBTEXT = "GIF Views";
    private final String HIRE_ME_BUTTON = "Hire Me";

    private SelenideElement
            headerOfUserPage = $(".HeaderSC-sc-1g0hdia"),
            analyticsBlockHeader = $(".ChannelAnalyticsContainer-sc-9g2ivj"),
            analyticsBlockCount = $(".ChannelAnalyticsContainer-sc-9g2ivj h1"),
            userSiteLink = $(".Website-sc-1bg717q"),
            userFacebookLink = $(".Container-sc-1mlrzqh").$("[name='facebook']"),
            hireMeButton = $(".HireMeButton-sc-h2ngct");

    public UserPage openUserPage() {
        open(testDataUserPage.userLink);

        return this;
    }

    public UserPage verifyUserName() {
        headerOfUserPage.shouldHave(text(testDataUserPage.userName));

        return this;
    }

    public UserPage verifyChannelName() {
        headerOfUserPage.shouldHave(text(testDataUserPage.channelName));

        return this;
    }

    public UserPage verifyAnalyticsBlock() {
        analyticsBlockHeader.shouldHave(
                text(GIF_UPLOADS_SUBTEXT),
                text(GIF_VIEWS_SUBTEXT));

        analyticsBlockCount.shouldBe(visible);

        return this;
    }

    public UserPage verifyUserSiteLink() {
        userSiteLink.shouldHave(text(testDataUserPage.userSiteLink));

        return this;
    }

    public UserPage verifyUserFacebookLink() {
        userFacebookLink.shouldHave(attribute(
                "href",
                testDataUserPage.userFacebookLink));

        return this;
    }

    public UserPage verifyHireMeButton() {
        hireMeButton.shouldHave(text(HIRE_ME_BUTTON));

        return this;
    }
}
