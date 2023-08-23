package com.test.project.selenide_demo;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class LoginPage {

	public static SelenideElement usernameField = $("#username");
	private final SelenideElement passwordField = $("#password");
	private final SelenideElement loginButton = $(".fa-sign-in");
	private final SelenideElement logoutButton = $("a[class='button secondary radius']");
	private final SelenideElement header = $("h2");
	private final SelenideElement successText = $("#flash");

	public void verifyHeader() {
		header.shouldHave(text("Login Page"));
	}

	public void enterUsername(String username) {
		usernameField.setValue(username);
	}

	public void enterPassword(String password) {
		passwordField.val(password);
	}

	public void clickLoginButton() {
		loginButton.should(exist).shouldBe(enabled).click();
	}

	public void clickOnLogoutButton() {
		logoutButton.shouldBe(enabled).click();

	}

	public void verifySuccessText() {
		successText.shouldHave(text("You logged into a secure area!"));
	}
}
