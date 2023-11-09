package calculator;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * The <code>Calculator</code> class represents a calculator.
 */
public class Calculator {
    private final ArrayList<Operation> operations;

    public Calculator() {
        this.operations = new ArrayList<>();
        this.initialise();
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }

    /**
     * Adds a new operation to the list of operations of the calculator.
     * @param operation the operation to be added
     */
    public void addOperation(Operation operation) {
        this.operations.add(operation);
    }

    /**
     * Initialises the calculator by adding all the operations the calculator can perform.
     * Available operations are:
     * <ul>
     *     <li>Addition</li>
     *     <li>Subtraction</li>
     *     <li>Multiplication</li>
     *     <li>Division</li>
     *     <li>Sine</li>
     *     <li>Cosine</li>
     *     <li>Tangent</li>
     *     <li>Square Root</li>
     *     <li>Exponential</li>
     * </ul>
     */
    private void initialise() {
        Addition addition = new Addition();
        this.addOperation(addition);

        Subtraction subtraction = new Subtraction();
        this.addOperation(subtraction);

        Multiplication multiplication = new Multiplication();
        this.addOperation(multiplication);

        Division division = new Division();
        this.addOperation(division);

        Sine sine = new Sine();
        this.addOperation(sine);

        Cosine cosine = new Cosine();
        this.addOperation(cosine);

        Tangent tangent = new Tangent();
        this.addOperation(tangent);

        SquareRoot squareRoot = new SquareRoot();
        this.addOperation(squareRoot);

        Exponential exponential = new Exponential();
        this.addOperation(exponential);
    }

    /**
     *  This function prints all the actions the calculator can perform,
     *  along with the number that corresponds to each action.
     */
    public void showActions() {
        System.out.println("0 to Exit");

        Calculator calculator = new Calculator();
        int i = 1;
        for (Operation operation : calculator.getOperations()) {
            System.out.println(i + " for " + operation.getName());
            i++;
        }
    }

    /**
     * This function receives user input (an integer >= 0) about which action to perform.
     * @return the choice of the user (integer >= 0)
     */
    public int chooseAction() {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        int choice = -1;
        boolean validChoice = false;

        while (!validChoice) {
            try {
                System.out.println();
                showActions();
                System.out.print("Enter your choice: ");
                choice = scan.nextInt();
            }
            catch (Exception e) {
                System.out.println("Invalid choice, please try again.");
                scan.nextLine();
                continue;
            }

            if (choice > this.getOperations().size() || choice < 0) {
                System.out.println("Invalid choice, please try again.");
                scan.nextLine();
                continue;
            }
            validChoice = true;
        }
        return choice;
    }
}
