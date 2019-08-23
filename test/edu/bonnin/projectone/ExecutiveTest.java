////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2019.
// Author: Naomi Bonnin
// Course: CMIS 242 6383
// Project Name: Project 1 (Employee Salary)
// Filename: ExecutiveTest.java
// Updated: 8/23/19, 11:53 AM
// Description: This program loads information about employees from a " " delimited text file.
// It then sorts and displays that information in the console.
// Finally, it calculates and displays the average salaries for each year.
////////////////////////////////////////////////////////////////////////////////

package edu.bonnin.projectone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExecutiveTest {

    @Test
    void getStockPrice() {
        Executive tester = new Executive("John", 10000, 50, 2015);
        assertEquals(50, tester.getStockPrice(), "Stock Price must equal 50");
    }

    @Test
    void setStockPrice() {
        Executive tester = new Executive("John", 10000, 50, 2014);
        tester.setStockPrice(30);
        assertEquals(30, tester.getStockPrice(), "Stock Price must equal 30");
    }

    @Test
    void testAnnualSalary() {
        Executive tester = new Executive("John", 10000, 75, 2014);
        assertEquals(150000, tester.annualSalary(), "Annual salary must equal 150000");
        Executive tester2 = new Executive("John", 10000, 10, 2014);
        assertEquals(120000, tester2.annualSalary(), "Annual salary must equal 120000");
    }

    @Test
    void testToString() {
        Executive tester = new Executive("John", 10000, 75, 2014);
        String testString = "Name: John, Employee Type: Executive, Monthly Salary: $10000, Stock Price: $75";
        assertEquals(testString, tester.toString(), "Strings must be equal");
    }

    @Test
    void testDefault() {
        Executive tester = new Executive();
        assertEquals(-1, tester.getStockPrice(), "Value must be -1");
        assertEquals(-1, tester.getSalary(), "Salary must be -1");
    }
}