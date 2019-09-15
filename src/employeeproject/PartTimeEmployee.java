/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeproject;

/**
 *
 * @author 602497
 */
public class PartTimeEmployee extends EmployeeInfo{
    private double hourlyWage;
    private double hoursPerWeek;
    private double weeksPerYear;

    public double calcAnnualGrossIncome() {
        return (hourlyWage * hoursPerWeek * weeksPerYear);
    }
}
