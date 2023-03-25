package web.pages.loginPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    TestDataLoginPage testDataLoginPage = new TestDataLoginPage();

    private final String ERROR_LOGIN_TEXT = "Incorrect authentication credentials.";

    private SelenideElement
            emailInput = $("[type=\"email\"]"),
            passwordInput = $("[type='password']"),
            loginButton = $(withTagAndText("button", "Log in")),
            errorBanner = $(".flash-message__Text-sc-1cn8h5f-2");

    public LoginPage setValueEmailInput() {
        emailInput.setValue(testDataLoginPage.email);

        return this;
    }

    public LoginPage setValuePasswordInput() {
        passwordInput.setValue(testDataLoginPage.password);

        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();

        return this;
    }

    public LoginPage verifyLoginErrorText() {
        errorBanner.shouldHave(text(ERROR_LOGIN_TEXT));

        return this;
    }
}
