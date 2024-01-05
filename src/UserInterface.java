import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    String command;
    TaxCalculator calc = new TaxCalculator();

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Hello, welcome to the Abe Tax Calculator!");
        System.out.print("Enter your gross annual salary: ");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter taxes paid already (taxes withholding): ");
        double taxWithholding = Double.parseDouble(scanner.nextLine());
        calc.setSalary(salary);
        calc.setTaxWithholding(taxWithholding);
        System.out.println("Total taxes owed: " + calc.calculateTotalTax());
        System.out.println("Taxes still to be paid " + (calc.calculateTotalTax() - calc.getTaxWithholding()));
        System.out.println("Effective tax rate: " +
                String.format("%,.2f", calc.calculateEffectiveTaxRate()) + "%.");
    }
}
