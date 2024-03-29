////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2019.
// Author: Naomi Bonnin
// Course: CMIS 242 6383
// Project Name: Project 1 (Employee Salary)
// Filename: EmployeeList.java
// Updated: 8/14/19, 2:08 PM
// Description: This program loads information about employees from a " " delimited text file.
// It then sorts and displays that information in the console.
// Finally, it calculates and displays the average salaries for each year.
////////////////////////////////////////////////////////////////////////////////

package edu.bonnin.projectone;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class EmployeeList {
    /*
   Static method that opens the file that is contained in the package directory.
   Uses the BufferedReader class to parse through the text file and returns an ArrayList
   containing all of the lines.  Does not separate out the features.  Catches IO exceptions
   Notice that the employees.txt is contained in the src folder for this package.  The filePath gets the default
   path so the code is more system agnostic.
    */
    @NotNull
    private static ArrayList<String> readText() throws IOException {
        String filePath = new File("").getAbsolutePath(); //Gets the system path to make program agnostic
        BufferedReader reader = null;
        ArrayList<String> employees = new ArrayList<>();
        try { //Creates a new reader that opens the file and puts it into the inputstream
            reader = new BufferedReader(new FileReader(filePath + "/resources/employees.txt"));
            String currentLine = reader.readLine();
            while (currentLine != null) { //While there are entries remaining continue stepping through file
                employees.add(currentLine);
                currentLine = reader.readLine();
            }
        } catch (IOException e) { //Catches IOException for best practice.  Only prints the error
            e.printStackTrace();
        } finally { //closes the reader to save on memory.  More efficient than Java garbage collector
            assert reader != null;
            reader.close();
        }
        return employees;
    }

    /*
    This method takes a string as an argument.  That string is intended to be formatted (YEAR TYPE NAME SALARY OPTIONAL)
    It then converts that string to the necessary types and creates a new object based on the type.  A switch statement
    is used for readability.  Although switch statements based on Strings are known to be more computationally
    expensive.  It becomes more expensive to convert those statements into Integers and then use those for case
    statements.  The default case returns a default employee object in an effort to prevent the program from breaking
    due to an improperly formatted string.
     */
    @Contract("_ -> new")
    @NotNull
    private static Employee addEmployee(@NotNull String currentLine) {
        String[] line = currentLine.split(" "); //Splits the string based off the regex whitespace
        int year = Integer.parseInt(line[0]); //Makes the year an int so its compatible with created objects
        String type = line[1];
        String name = line[2];
        int salary = Integer.parseInt(line[3]); //Makes the salary an int so it is compatible with created objects

        switch (type) { //Creates the appropriate employee type based off of the type variable
            case "Employee":
                return new Employee(name, salary, year);

            case "Salesman": //Note the extra parseInt call because that value is optional
                return new Salesman(name, salary, Integer.parseInt(line[4]), year);

            case "Executive": //Note the extra parseInt call because that value is optional
                return new Executive(name, salary, Integer.parseInt(line[4]), year);

            default: //Creates a default employee so that the program doesn't crash
                return new Employee();
        }

    }

    private static void sortArrayList(ArrayList<Employee> list) {
        Collections.sort(list);
    }

    static void printList() throws IOException {
        ArrayList<String> text = readText(); //Reads in the text file and creates an ArrayList with each line
        ArrayList<Employee> employees = new ArrayList<>();
        int fourteenTotal = 0;
        int fourteenCount = 0;
        int fifteenTotal = 0;
        int fifteenCount = 0;

        for (String current : text) {
            employees.add(addEmployee(current)); //Creates a new employee for each entry.
        }
        sortArrayList(employees);
        for (Employee current : employees) { //Prints out each employee and calculates the average salary
            switch (current.getYear()) {
                case 2014:
                    fourteenTotal += current.annualSalary();
                    fourteenCount++;
                    System.out.print("Year: " + current.getYear() + ", ");
                    break;

                case 2015:
                    fifteenTotal += current.annualSalary();
                    fifteenCount++;
                    System.out.print("Year: " + current.getYear() + ", ");
                    break;

                default:
                    System.out.println("Year out of Range!");
            }
            System.out.println(current.toString() + ", Annual Salary: $" + current.annualSalary());
        }

        System.out.println("2014 Salary Average: $" + fourteenTotal / fourteenCount);
        System.out.println("2015 Salary Average: $" + fifteenTotal / fifteenCount);
    }
}
