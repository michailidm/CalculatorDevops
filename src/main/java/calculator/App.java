package calculator;
import java.util.*;
public class App
{
    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();
        calculator.initialise();

        int choice;
        boolean validInput;
        double num1 = 0, num2 = 0;
        System.out.println("Calculator");

        do {
            choice = calculator.chooseAction();

            if (choice == 0) {
                System.out.println("Exiting, Bye");
                return;
            }

            Scanner scan = new Scanner(System.in);

            // BINARY OPERATIONS (+, -, *, /)
            if (calculator.getOperations().get(choice - 1) instanceof BinaryOperation) {
                System.out.println("Enter two numbers");

                validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("Enter number 1: ");
                        num1 = scan.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Invalid number, please try again.");
                        scan.nextLine();
                        continue;
                    }
                    validInput = true;
                }

                validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("Enter number 2: ");
                        num2 = scan.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Invalid number, please try again.");
                        scan.nextLine();
                        continue;
                    }
                    validInput = true;
                }
            }

            // UNARY OPERATIONS (sin, cos, tan, sqrt, exp)
            if (calculator.getOperations().get(choice - 1) instanceof UnaryOperation) {
                validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("Enter number" + ((choice == 5 || choice == 6 || choice == 7)? " (in radians)": "") + ": ");
                        num1 = scan.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Invalid number, please try again.");
                        scan.nextLine();
                        continue;
                    }
                    validInput = true;
                }
            }

            // Remove sign from zero

            if (num1 == -0) {
                num1 = 0;
            }

            if (num2 == -0) {
                num2 = 0;
            }

            // Set operand(s) to the chosen operation,
            // perform the operation and
            // print the results.

            double result;
            Operation chosenOperation = calculator.getOperations().get(choice - 1);
            if (chosenOperation instanceof UnaryOperation) {
                ((UnaryOperation) chosenOperation).setOperand(num1);

                result = chosenOperation.perform();
                System.out.println(chosenOperation.showOperationExpression() + " = " + result);

            } else if (chosenOperation instanceof BinaryOperation) {
                ((BinaryOperation) chosenOperation).setFirstOperand(num1);
                ((BinaryOperation) chosenOperation).setSecondOperand(num2);

                result = chosenOperation.perform();
                System.out.println(chosenOperation.showOperationExpression() + " = " + result);
            }

        } while (choice != 0);

    }

}
