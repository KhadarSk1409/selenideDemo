package com.test.project.selenide_demo;

import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.TextReportExtension;

@ExtendWith(TextReportExtension.class)
public class LoginTest {
	private LoginPage loginPage;

	@BeforeEach
	public void setUp() {

		Configuration.browser = "chrome"; // You can choose the browser of your wish
		// by using this Configuration class like we do in desired capabilities
		//Configuration.browserSize = "1920x1080";
		Configuration.timeout = 30000;

		loginPage = open("https://the-internet.herokuapp.com/login", LoginPage.class);
		WebDriverRunner.getWebDriver().manage().window().maximize();
		loginPage.verifyHeader();

	}

	@Test
	public void successfulLoginTest() {
		loginPage.enterUsername("tomsmith");
		loginPage.enterPassword("SuperSecretPassword!");
		loginPage.clickLoginButton();

		loginPage.verifySuccessText();

		// Click on Logout
		loginPage.clickOnLogoutButton();
		loginPage.verifyHeader(); //Validating login page header after clicking on logout

	}

}
