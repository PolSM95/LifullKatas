package com.company.hole05;

public class TaxCalculator {

    public double taxFor(final double grossSalary) {
        final double upperTaxBracketStart = 40000;
        final double upperTaxBracketRate = 0.4;
        final double upperTaxBracketGross = Math.max(grossSalary - upperTaxBracketStart, 0.0);
        
        final double middleTaxBracketStart = 20000;
        final double middleTaxBracketRate = 0.2;
        final double middleTaxBracketGross = Math.max(Math.min(grossSalary, upperTaxBracketStart) - middleTaxBracketStart, 0.0);

        final double lowerTaxBracketStart = 5000;
        final double lowerTaxBracketRate = 0.1;
        final double lowerTaxBracketGross = Math.max(Math.min(grossSalary, middleTaxBracketStart) - lowerTaxBracketStart, 0.0);

        return lowerTaxBracketGross * lowerTaxBracketRate + middleTaxBracketGross * middleTaxBracketRate + upperTaxBracketGross * upperTaxBracketRate;
    }
}
