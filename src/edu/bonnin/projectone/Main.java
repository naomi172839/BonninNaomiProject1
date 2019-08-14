////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2019.
// Author: Naomi Bonnin
// Course: CMIS 242 6383
// Project Name: Project 1 (Employee Salary)
// Filename: Main.java
// Updated: 8/14/19, 2:08 PM
// Description: This program loads information about employees from a " " delimited text file.
// It then sorts and displays that information in the console.
// Finally, it calculates and displays the average salaries for each year.
////////////////////////////////////////////////////////////////////////////////


package edu.bonnin.projectone;

import java.io.IOException;


/*
This is the "Main" class.  It contains the main method and is the intro point into the program.
 */
public class Main {

    /*
    The main method takes the String[] args argument which is the standard.  In this case, args is not used as there
    are no command line arguments.  One possible use would be to take in the file location.  The method makes extensive
    use of the ArrayList object to hold both strings and employees.  This is because it allows for more flexibility
    when compared to standard arrays.  Although the instructions state there will be no more than 10 total entries per
    year, it is in my opinion better practice to account for the fact that there could potentially be more entries
    in the future.  By accounting for that now, the program is more flexible.  There is of course a memory trade off
    when using an ArrayList when compared to a standard array.  However given that this is intended to be executed on
    a modern computer with a significant amount of memory and computational power, the impact would be minimal.  If the
    intended application was an embedded system or a system that had limited memory than an array would be a better
    choice overall.  The fourteenTotal, fourteenCount, fifteenTotal, fifteenCount variables are being used to keep a
    running count in order to calculate a yearly average.  This could be expanded to a more object oriented approach
    however given that there is no intent to expand this program or reuse this code it is unnecessary.  The method also
    makes used of the "enhanced" for loops (or foreach) to iterate through all of the objects in the ArrayList.
    This method allows the program to account for a larger number than 10 entries per year.  Finally, the method
    uses each objects toString method to print out the object properties and its annualSalary to display its annual
    salary.  The switch statement allows tracking of the average salary of an unlimited number of entries per year.
    These averages are displayed.  In an ideal world, the program would take into account additional years, however
    for the sake of brevity, only the two years are accounted for.
     */
    public static void main(String[] args) throws IOException {
        EmployeeList.printList();
    }
}