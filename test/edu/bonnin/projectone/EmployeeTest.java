package edu.bonnin.projectone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {

    @Test
    void getName() {
        Employee tester = new Employee("John", 2000, 2015);
        assertEquals("John", tester.getName(), "Name must equal John");
    }

    @Test
    void setName() {
        Employee tester = new Employee("John", 2000, 2015);
        tester.setName("James");
        assertEquals("James", tester.getName(), "Name must equal James");
    }

    @Test
    void getSalary() {
        Employee tester = new Employee("John", 2000, 2014);
        assertEquals(2000, tester.getSalary(), "Salary must equal 2000");
    }

    @Test
    void setSalary() {
        Employee tester = new Employee("John", 2000, 2014);
        tester.setSalary(6000);
        assertEquals(6000, tester.getSalary(), "Salary must equal 6000");
    }

    @Test
    void getYear() {
        Employee tester = new Employee("John", 2000, 2014);
        assertEquals(2014, tester.getYear(), "Year must equal 2014");
    }

    @Test
    void setYear() {
        Employee tester = new Employee("John", 2000, 2014);
        tester.setYear(2015);
        assertEquals(2015, tester.getYear(), "Year must equal 2015");
    }

    @Test
    void annualSalary() {
        Employee tester = new Employee("James", 2000, 2014);
        assertEquals(24000, tester.annualSalary(), "Annual salary must equal 24000");
    }

    @Test
    void testToString() {
        Employee tester = new Employee("John", 2000, 2014);
        String testString = "Name: John, Monthly Salary: $2000";
        assertEquals(testString, tester.toString(), "String must match");
    }
}