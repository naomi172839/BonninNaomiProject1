////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2019.
// Author: Naomi Bonnin
// Course: CMIS 242 6383
// Project Name: Project 1 (Employee Salary)
// Filename: Employee.java
// Updated: 8/13/19, 4:18 AM
// Description: This program loads information about employees from a " " delimited text file.
// It then sorts and displays that information in the console.
// Finally, it calculates and displays the average salaries for each year.
////////////////////////////////////////////////////////////////////////////////

package edu.bonnin.projectone;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/*
The Employee superclass contains basic information such as the employee's name and monthly salary
The instructions specify that the salary is in whole dollars, meaning that there is no need for floating point numbers.
The project requirements specify only 3 methods, however I believe that a default constructor should
always be used.  In addition, a month in year constant is defined as a best practice to help with
readability.  Furthermore, the standard getters and setters are defined to allow for flexibility.
The year is also tracked for later use.
 */
class Employee implements Comparable<Employee> {

    private final static int MONTH_IN_YEAR = 12;  //There are 12 months in a year.  Change for other planets
    private int salary;
    private String name;
    private int year;

    //Default constructor, allows for flexibility when creating new objects
    //Salary should never be negative, so if salary is negative, the employee is not valid
    //Year should never be negative so if it is negative then the employee is not valid
    @Contract(pure = true)
    Employee() {
        this.setName("Uninitialized");
        this.setSalary(-1);
        this.setYear(-1);
    }

    //Standard constructor, allows instantiation using 2 arguments, name and salary
    @Contract(pure = true)
    Employee(String name, int salary, int year) {
        this.setName(name);
        this.setSalary(salary);
        this.setYear(year);
    }

    @Contract(pure = true)
    static int getMonthInYear() {
        return MONTH_IN_YEAR;
    }

    //Standard getter for name.  Allows for multiple approaches to access class variables
    String getName() {
        return this.name;
    }

    //Standard setter for name.  Allows for multiple approaches to access class variables.
    void setName(String name) {
        this.name = name;
    }

    //Standard getter for salary.  Allows for multiple approaches to access class variables.
    int getSalary() {
        return this.salary;
    }

    //Standard setter for salary.  Allows for multiple approaches to access class variables.
    void setSalary(int salary) {
        this.salary = salary;
    }

    //Standard getter for year
    int getYear() {
        return this.year;
    }

    //Standard setter for year
    void setYear(int year) {
        this.year = year;
    }

    //Returns the annual salary of the employee by multiplying the monthly salary and total months
    public int annualSalary() {
        return this.getSalary() * getMonthInYear();
    }

    //Override the Java default toString method and returns the name and monthly salary.  Unformatted.
    public String toString() {
        return "Name: " + this.getName() + ", Monthly Salary: $" + this.getSalary();
    }

    @Override
    public int compareTo(@NotNull Employee e) {
        return this.getYear() - e.getYear();
    }
}
