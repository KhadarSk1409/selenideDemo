package com.test.project.selenide_demo.seperate_tests;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.TextReportExtension;

@ExtendWith(TextReportExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Student Registration Form Test")
public class StudentRegistrationForm {

	@Test
	@DisplayName("Verifying filling student registration from")
	@Order(1)
	public static void main(String[] args) {

		open("https://demoqa.com/automation-practice-form");
		WebDriverRunner.getWebDriver().manage().window().maximize();
		$(".main-header").shouldHave(text("Practice Form"));

		// Fill the Form
		$("#firstName").val("Khadar");
		$("[placeholder='Last Name']").setValue("Shaik");
		$("#userEmail").sendKeys("shaikkhadhar@technoidentity.com");
		$("label[for='gender-radio-1']").shouldHave(text("Male")).click();

		$(By.xpath("//input[@id='userNumber']")).setValue("7013771786");

		String dateToEnter = "2023-07-10";
		$("#dateOfBirthInput").setValue(dateToEnter);
		$(byText("Subjects")).should(exist).hover().click();
		
		//$("label[for='hobbies-checkbox-3']").click();
		
		String file = "myPic.jpeg";
		$("#uploadPicture").uploadFromClasspath(file);
		
		$("#currentAddress").setValue("Andhra Pradesh");
		
		/*
		 * $("#state").click();
		 * $(".css-2613qy-menu").should(appear).selectOptionByValue("Haryana");
		 */
		//$(By.id("submit")).should(exist).click();
		
		

	}

}
