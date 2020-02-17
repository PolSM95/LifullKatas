package com.company.hole03;

public class Payslip {
    private final double grossSalary;

    public Payslip(final double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getNet() {
        return grossSalary - new TaxCalculator().taxFor(grossSalary);
    }

}
