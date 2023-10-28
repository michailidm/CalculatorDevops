package calculator;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class App extends JFrame
{
    static JFrame frame;
    static JTextField textField;
    String operator, operand1, operand2;

    public static void main(String[] args)
    {
        frame = new JFrame("calculator");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        textField = new JTextField(16);
        textField.setEditable(false);

        // create number buttons
        JButton[] numButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
        }

        JButton additionButton, subtractionButton, multiplicationButton, divisionButton,
                equalityButton, eraseButton, decimalPointButton;

        additionButton = new JButton("+");
        subtractionButton = new JButton("-");
        multiplicationButton = new JButton("*");
        divisionButton = new JButton("/");
        equalityButton = new JButton("=");
        eraseButton = new JButton("C");
        decimalPointButton = new JButton(".");

        JPanel panel = new JPanel();
        panel.add(textField);
        for (int i = 0; i < 10; i++) {
            panel.add(numButtons[i]);
        }
        panel.add(additionButton);
        panel.add(subtractionButton);
        panel.add(multiplicationButton);
        panel.add(divisionButton);
        panel.add(equalityButton);
        panel.add(eraseButton);
        panel.add(decimalPointButton);

        panel.setBackground(Color.white);
        frame.add(panel);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Calculator calculator = new Calculator();
        int choice;
        boolean validInput;
        double num1 = 0, num2 = 0;
        System.out.println("Calculator");
        do {
            // Choose an action
            choice = calculator.chooseAction();
            if (choice == 0) {
                System.out.println("Exiting, Bye");
                return;
            }

            Operation chosenOperation = calculator.getOperations().get(choice - 1);
            System.out.println(chosenOperation.getName());
            Scanner scan = new Scanner(System.in).useLocale(Locale.US);

            // Scan operand(s) of the chosen operation

            // BINARY OPERATIONS (+, -, *, /)
            if (chosenOperation instanceof BinaryOperation) {
                System.out.println("Enter two numbers");
                // first operand
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

                // second operand
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
            if (chosenOperation instanceof UnaryOperation) {
                validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("Enter number" + ((chosenOperation instanceof TrigonometricOperation)? " (in radians)": "") + ": ");
                        num1 = scan.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Invalid number, please try again.");
                        scan.nextLine();
                        continue;
                    }
                    validInput = true;
                }
            }

            // Set operand(s) to the chosen operation,
            // perform the operation and
            // print the results.
            double result;
            chosenOperation = calculator.getOperations().get(choice - 1);
            if (chosenOperation instanceof UnaryOperation) {
                ((UnaryOperation) chosenOperation).setOperand(num1);

                result = chosenOperation.perform();

                System.out.println(chosenOperation.showExpression() + " = " + chosenOperation.simplifyNumber(result));

            } else if (chosenOperation instanceof BinaryOperation) {
                ((BinaryOperation) chosenOperation).setFirstOperand(num1);
                ((BinaryOperation) chosenOperation).setSecondOperand(num2);

                result = chosenOperation.perform();

                System.out.println(chosenOperation.showExpression() + " = " + chosenOperation.simplifyNumber(result));
            }

        } while (choice != 0);
    }
}
