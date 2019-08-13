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
        String testString = "Name: John, Monthly Salary: $10000, Stock Price: $75";
        assertEquals(testString, tester.toString(), "Strings must be equal");
    }
}