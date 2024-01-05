import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    String command;
    TaxCalculator calc = new TaxCalculator();

    public UserInterface() {
        scanner = new Scanner(System.in);
    };

    public void start() {
        System.out.println("I am the User Interface.");
        command = scanner.nextLine();
    }
}
