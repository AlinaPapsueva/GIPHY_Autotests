package web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PrivacyPolicyPage {

    private final String PRIVACY_POLiCY_HEADER = "GIPHY Privacy Policy";
    private SelenideElement
            bannerLink = $(".Banner-sc-iopojr").$("[href='/privacy']"),
            pageHeader = $(".page-header");

    public PrivacyPolicyPage bannerLinkClick() {
        bannerLink.click();

        return this;
    }

    public PrivacyPolicyPage verifyPageHeaderText() {
        pageHeader.shouldHave(text(PRIVACY_POLiCY_HEADER));

        return this;
    }
}
