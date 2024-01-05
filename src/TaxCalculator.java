public class TaxCalculator {
    private double salary;
    private double taxWithholding;
    final private double standardDeduction;
    // 0 = single
    // 1 = married, filing jointly.
    private int filingStatus;
    final private Double[] taxRates = {0.10, 0.12, 0.22, 0.24, 0.32, 0.35, 0.37};
    final private int[] lowerBracket = {0, 11001, 44726, 95376, 182101, 231251, 578126};
    final private int[] upperBracket = {11000, 44725, 95375, 182100, 231250, 578125, Integer.MAX_VALUE};

    /*
    Tax Brackets for income earned in 2023.
    10% - $0 to $11,000
    12% - $11,001 to $44,725
    22% - $44,726 to $95,375
    24% - $95,376 to $182,100
    32% - $182,101 to $231,250
    35% - $231,251 to $578,125
    37% - $578,126 ++

    Tax brackets pulled from https://turbotax.intuit.com/tax-tools/calculators/tax-bracket/
*/

    public TaxCalculator() {
        this.standardDeduction = 13850;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getTaxWithholding() {
        return this.taxWithholding;
    }

    public void setTaxWithholding(double taxWithholding) {
        this.taxWithholding = taxWithholding;
    }

    public String getFilingStatus() {
        if (filingStatus == 0) return "Single"; else {
            return "Married, filing jointly";
        }
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public double calculateEffectiveTaxRate() {
        return this.calculateTotalTax() / this.salary * 100;
    }

    public double calculateTotalTax() {
        double totalTaxOwed = 0;

        int i = 0;
        while (this.salary - this.standardDeduction > this.lowerBracket[i]) {
            if (this.salary - this.standardDeduction > this.upperBracket[i]) {
                totalTaxOwed += (this.upperBracket[i] - this.lowerBracket[i]) * this.taxRates[i];
            } else {
                totalTaxOwed += ((this.salary - this.standardDeduction) - this.lowerBracket[i]) * this.taxRates[i];
            }
            i++;
        }

        return totalTaxOwed;
    }
}
