////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2019.
// Author: Naomi Bonnin
// Course: CMIS 242 6383
// Project Name: Project 1 (Employee Salary)
// Filename: SalesmanTest.java
// Updated: 8/13/19, 4:18 AM
// Description: This program loads information about employees from a " " delimited text file.
// It then sorts and displays that information in the console.
// Finally, it calculates and displays the average salaries for each year.
////////////////////////////////////////////////////////////////////////////////

package edu.bonnin.projectone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalesmanTest {

    @Test
    void getAnnualSales() {
        Salesman tester = new Salesman("John", 5000, 100000, 2014);
        assertEquals(100000, tester.getAnnualSales(), "Annual sales must be 100000");
    }

    @Test
    void setAnnualSales() {
        Salesman tester = new Salesman("John", 5000, 100000, 2014);
        tester.setAnnualSales(50000);
        assertEquals(50000, tester.getAnnualSales(), "Annual sales must be 50000");
    }

    @Test
    void testAnnualSalary() {
        Salesman tester = new Salesman("John", 5000, 100000, 2014);
        assertEquals(62000, tester.annualSalary(), "Annual salary must equal 62000");
        Salesman tester2 = new Salesman("James", 2000, 10000000, 2014);
        assertEquals(44000, tester2.annualSalary(), "Annual salary must equal 44000");
    }

    @Test
    void testToString() {
        Salesman tester = new Salesman("John", 5000, 100000, 2014);
        String testString = "Name: John, Monthly Salary: $5000, Annual Sales: $100000";
        assertEquals(testString, tester.toString(), "Strings must be equal");
    }
}