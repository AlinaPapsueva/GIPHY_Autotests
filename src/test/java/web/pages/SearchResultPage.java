package web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    private SelenideElement
            gifCard = $(".giphy-grid a");


    public SearchResultPage openFirstGifCard() {
        gifCard.click();

        return this;
    }


}
