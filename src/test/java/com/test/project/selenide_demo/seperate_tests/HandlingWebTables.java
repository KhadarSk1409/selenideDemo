package com.test.project.selenide_demo.seperate_tests;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

public class HandlingWebTables {
	public static void main(String[] args) {
		open("https://the-internet.herokuapp.com/tables");

		// Find the table element
		$("#table1").should(Condition.appear);

		// Get all rows of the table
		ElementsCollection rows = $$("#table1 tbody tr");

		// Print the number of rows in the table
		System.out.println("Number of rows: " + rows.size());

		// Get the data from the table and print it
		for (int i = 0; i < rows.size(); i++) {
			ElementsCollection cells = rows.get(i).$$("td");
			String firstName = cells.get(0).getText();
			String lastName = cells.get(1).getText();
			String email = cells.get(2).getText();
			String due = cells.get(3).getText();
			String website = cells.get(4).getText();

			System.out.println(
					"Row " + (i + 1) + ": " + firstName + ", " + lastName + ", " + email + ", " + due + ", " + website);
		}
	}
}
