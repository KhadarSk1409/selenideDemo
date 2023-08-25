package com.test.project.selenide_demo.seperate_tests;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.TextReportExtension;

@ExtendWith(TextReportExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("DEMO QA TEST USING SELENIDE AUTOMATION FRAMEWORK")
public class DemoQaElementsTest {

	@Test
	@DisplayName("Verifying Elements tab and Textbox tab")
	@Order(1)
	public void verifyElementsAndTextBoxTab() {

		open("https://demoqa.com/");
		WebDriverRunner.getWebDriver().manage().window().maximize();
		
		$("img[src='/images/Toolsqa.jpg']").should(exist); // Verify the ToolsQA image
		
		$(byText("Elements")).should(exist).shouldBe(enabled).click(); // Click on Elements
		
		$(".main-header").shouldHave(text("Elements")).should(appear); // Validate the header

		
		// Text Box
		$(byText("Text Box")).should(exist).click();
		$(".main-header").shouldHave(text("Text Box")); //Validate the header

		$("#userName").val("Sk Nasir Ahmed");
		$("#userEmail").setValue("shaik2a4@gmail.com");
		$("[placeholder='Current Address']").sendKeys("Telangana, Hyderabad");
		$(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Andhra Pradesh");
		$(By.xpath("//button[@id='submit']")).should(exist).click();

		// Check Box
		$(byText("Check Box")).should(exist).shouldBe(enabled).click();
		$("button[title='Toggle']").click();
		$("#tree-node li li:nth-child(1) button").should(appear).click();
	}

	@Test
	@DisplayName("Verifying Webtables tab")
	@Order(2)
	public void webTables() {

		open("https://demoqa.com/webtables");
		$(".main-header").shouldHave(text("Web Tables")).should(appear); // Validate the header

		SelenideElement webTable = $(".rt-table");
		$(webTable).should(exist);

		ElementsCollection rows = $$(".rt-tr-group");

		System.out.println("Number of rows: " + rows.size());

		if (rows.size() == 0) {
			System.out.println("No rows available");
			return;
		}

		for (int i = 0; i < rows.size(); i++) {
			ElementsCollection cells = rows.get(i).$$(".rt-td");
			String firstName = cells.get(0).getText();
			String lastName = cells.get(1).getText();
			String age = cells.get(2).getText();
			String email = cells.get(3).getText();
			String salary = cells.get(4).getText();
			String department = cells.get(5).getText();
			String action = cells.get(5).getText();

			System.out.println("Row " + (i + 1) + ": " + firstName + " " + lastName + " " + age + " " + email + " "
					+ salary + " " + department + " " + action);

		}

	}

	@Test
	@DisplayName("Verifying filling student registration from")
	@Order(3)
	public void formFillTest() {

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

		$("label[for='hobbies-checkbox-3']").click();

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
