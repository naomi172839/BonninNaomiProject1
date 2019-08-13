////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2019.
// Author: Naomi Bonnin
// Course: CMIS 242 6383
// Project Name: Project 1 (Employee Salary)
// Filename: Executive.java
// Updated: 8/13/19, 5:01 AM
// Description: This program loads information about employees from a " " delimited text file.
// It then sorts and displays that information in the console.
// Finally, it calculates and displays the average salaries for each year.
////////////////////////////////////////////////////////////////////////////////

package edu.bonnin.projectone;

import org.jetbrains.annotations.Contract;

/*
The subclass Executive extends the Employee superclass by adding the stockPrice.  Standard
getters and setters are provided for flexibility.  In addition, the BONUS_THRESHOLD constant is
defined for readability.  A default constructor is also provided as a matter of best practice.
 */
class Executive extends Employee {

    private final static int BONUS_THRESHOLD = 50; //The threshold at which an executive would get a bonus
    private final static int BONUS_AMOUNT = 30000; //The specified bonus amount
    private int stockPrice;

    //Default constructor.  Salary and stockPrice should never be negative in a properly instantiated
    //Executive object.
    Executive() {
        super();
        this.setStockPrice(-1);
    }

    //Standard constructor that takes 3 arguments: name, salary, and stock price.  Note use of the
    //super keyword to reference the superclass variables.
    Executive(String name, int salary, int stockPrice, int year) {
        super(name, salary, year);
        this.setStockPrice(stockPrice);
    }

    @Contract(pure = true)
    private static int getBonusThreshold() {
        return BONUS_THRESHOLD;
    }

    @Contract(pure = true)
    private static int getBonusAmount() {
        return BONUS_AMOUNT;
    }

    //Standard getter
    @Contract(pure = true)
    int getStockPrice() {
        return this.stockPrice;
    }

    //Standard setter
    void setStockPrice(int stockPrice) {
        this.stockPrice = stockPrice;
    }

    //Overrides the Employee annualSalary method by taking into account the bonus.  In addition,
    //The BONUS_THRESHOLD constant is utilized for readability.
    @Override
    public int annualSalary() {
        if (getStockPrice() > getBonusThreshold()) { //Checks if the executive should receive the bonus
            return super.annualSalary() + getBonusAmount();
        } else {
            return super.annualSalary();
        }
    }

    //Overrides the Employee toString method.  Uses the superclass method to avoid code duplication
    public String toString() {
        return super.toString() + ", Stock Price: $" + getStockPrice();
    }
}
