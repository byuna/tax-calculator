import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    String command;
    TaxCalculator calc = new TaxCalculator();

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void start() {

        calc.setSalary(251634);
        System.out.println("Salary: 251634");
        System.out.println("Taxes owed: " + calc.calculateTotalTax());
        System.out.println("Effective tax rate: " +
                String.format("%,.2f", calc.calculateEffectiveTaxRate()) + "%.");
    }
}
