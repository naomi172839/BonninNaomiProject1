////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2019.
// Author: Naomi Bonnin
// Course: CMIS 242 6383
// Project Name: Project 1 (Employee Salary)
// Filename: Salesman.java
// Updated: 8/23/19, 11:53 AM
// Description: This program loads information about employees from a " " delimited text file.
// It then sorts and displays that information in the console.
// Finally, it calculates and displays the average salaries for each year.
////////////////////////////////////////////////////////////////////////////////

package edu.bonnin.projectone;

import org.jetbrains.annotations.Contract;

/*
The Salesman subclass extends the Employee superclass by adding the annual salesVariable.
In addition the COMMISSION_AMOUNT and MAXIMUM_COMMISSION constants are defined for readability.
Getters and setters are provided for the annualSales variable.  A default constructor is provided
for flexibility and as a best practice.
 */
class Salesman extends Employee {

    private final static double COMMISSION_AMOUNT = 0.02;  //The percentage that a commission is
    private final static double MAXIMUM_COMMISSION = 20000.0; //The maximum allowable commission
    private final static String EMPLOYEE_TYPE = "Salesman";
    private int annualSales;

    //Default constructor.  Salary and annual sales should never be negative in a correctly
    //instantiated Salesman object.
    Salesman() {
        super();
        super.setType(EMPLOYEE_TYPE);
        this.setAnnualSales(-1);
    }

    //Constructor taking 3 arguments. name, salary and annualSales.  Uses the super keyword
    //to reference superclass variables.
    Salesman(String name, int salary, int annualSales, int year) {
        super(name, salary, year);
        super.setType(EMPLOYEE_TYPE);
        this.setAnnualSales(annualSales);
    }

    @Contract(pure = true)
    private static double getCommissionAmount() {
        return COMMISSION_AMOUNT;
    }

    @Contract(pure = true)
    private static double getMaximumCommission() {
        return MAXIMUM_COMMISSION;
    }

    //Returns the annualSales variable for the Salesman object.
    int getAnnualSales() {
        return this.annualSales;
    }

    //Sets the annual sales
    void setAnnualSales(int annualSales) {
        this.annualSales = annualSales;
    }

    //Overrides the Employee annualSalary method.  Calculates the commission based off of
    //the class constants.  Also takes into account the maximum commission.
    @Override
    public int annualSalary() {
        int commission;
        if (getAnnualSales() * getCommissionAmount() > getMaximumCommission()) { //Checks if the commission would be over the max
            commission = (int) getMaximumCommission();
        } else {
            commission = (int) (getAnnualSales() * getCommissionAmount());
        }
        return (this.getSalary() * getMonthInYear()) + commission;
    }

    //Overrides the Employee toString method.  Expands on it rather then duplicating code.
    @Override
    public String toString() {
        return super.toString() + ", Annual Sales: $" + this.getAnnualSales();
    }
}
