package edu.bonnin.projectone;

/*
The Salesman subclass extends the Employee superclass by adding the annual salesVariable.
In addition the COMMISSION_AMOUNT and MAXIMUM_COMMISSION constants are defined for readability.
Getters and setters are provided for the annualSales variable.  A default constructor is provided
for flexibility and as a best practice.
 */
class Salesman extends Employee {

    private final static double COMMISSION_AMOUNT = 0.02;  //The percentage that a commission is
    private final static double MAXIMUM_COMMISSION = 20000.0; //The maximum allowable commission
    private int annualSales;

    //Default constructor.  Salary and annual sales should never be negative in a correctly
    //instantiated Salesman object.
    public Salesman() {
        super();
        this.setAnnualSales(-1);
    }

    //Constructor taking 3 arguments. name, salary and annualSales.  Uses the super keyword
    //to reference superclass variables.
    Salesman(String name, int salary, int annualSales, int year) {
        super(name, salary, year);
        this.setAnnualSales(annualSales);
    }

    private static double getCommissionAmount() {
        return COMMISSION_AMOUNT;
    }

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