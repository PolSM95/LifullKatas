package com.company.hole05;

public class TaxCalculator {
    public double taxFor(final double grossSalary) {
        final int middleTaxBracketStart = 20000;
        final double lowerTaxBracketGross = Math.max(Math.min(grossSalary, middleTaxBracketStart) - 5000, 0.0);
        final int upperTaxBracketStart = 40000;
        final double middleTaxBracketGross = Math.max(Math.min(grossSalary, upperTaxBracketStart) - middleTaxBracketStart, 0.0);
        final double upperTaxBracketGross = Math.max(grossSalary - upperTaxBracketStart, 0.0);
        return lowerTaxBracketGross * 0.1 + middleTaxBracketGross * 0.2 + upperTaxBracketGross * 0.4;
    }
}
