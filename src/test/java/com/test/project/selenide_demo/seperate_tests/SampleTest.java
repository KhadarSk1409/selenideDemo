package com.test.project.selenide_demo.seperate_tests;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.codeborne.selenide.junit5.TextReportExtension;

import dev.failsafe.internal.util.Assert;

@ExtendWith(TextReportExtension.class)
public class SampleTest {
	

	@Test
	public static void main(String[] args) {

		open("https://the-internet.herokuapp.com/login");
		$("h2").shouldHave(text("Login Page"));
		$("#username").setValue("tomsmith");
		$("#password").sendKeys("SuperSecretPassword!");
		$(".fa-sign-in").click();

		$("#flash").shouldHave(text(" You logged into a secure area!"));
		
		String secureAreaText = "Welcome to the Secure Area. When you are done click logout below.";
		Assert.isTrue(true, secureAreaText);
		
		$(byText("Logout")).should(exist).shouldBe(enabled).click();

	}

}
