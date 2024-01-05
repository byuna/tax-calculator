public class TaxCalculator {
    private double salary;
    private double taxWithholding;
    private double totalTaxOwed;
    // 0 = single
    // 1 = married, filing jointly.
    private int filingStatus;

/*
    Tax Brackets for income earned in 2023.
    10% - $0 to $11,000
    22% - $44,726 to $95,375
    24% - $95,376 to $182,100
    32% - $182,101 to $231,250
    35% - $231,251 to $578,125
    37% - $578,126 ++

    Tax brackets pulled from https://turbotax.intuit.com/tax-tools/calculators/tax-bracket/
*/

    public TaxCalculator() {

    }

    private double getSalary() {
        return this.salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    private double getTaxWithholding() {
        return this.taxWithholding;
    }

    private void setTaxWithholding(double taxWithholding) {
        this.taxWithholding = taxWithholding;
    }

    private String getFilingStatus() {
        if (filingStatus == 0) {
            return "Single";
        } else {
            return "Married, filing jointly";
        }
    }

    private void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    private double calculateEffectiveTaxRate() {
        return totalTaxOwed / salary;
    }


}
