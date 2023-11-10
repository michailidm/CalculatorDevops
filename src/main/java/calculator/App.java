package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class App implements ActionListener
{
    JFrame frame;
    JTextField textField;
    Calculator calculator = new Calculator();
    JButton[] numButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton additionButton, subtractionButton, multiplicationButton, divisionButton;
    JButton equalityButton, decimalPointButton, clrButton, delButton;
    JPanel panel;

    double operand1 = 0, operand2 = 0, result = 0;
    char operator;

    public App() {
        frame = new JFrame("Calculator");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //GridLayout gridLayout = new GridLayout(4, 5);
        //frame.setLayout(gridLayout);

        // create the textfield for the output
        textField = new JTextField(16);
        textField.setEditable(false);

        // create the panel
        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.add(textField);


        // create number buttons and add them to the panel
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(this);
            numButtons[i] = button;
        }

        additionButton = new JButton("+");
        subtractionButton = new JButton("-");
        multiplicationButton = new JButton("*");
        divisionButton = new JButton("/");
        equalityButton = new JButton("=");
        decimalPointButton = new JButton(".");
        clrButton = new JButton("C");
        delButton = new JButton("Delete");

        functionButtons[0] = additionButton;
        functionButtons[1] = subtractionButton;
        functionButtons[2] = multiplicationButton;
        functionButtons[3] = divisionButton;
        functionButtons[4] = equalityButton;
        functionButtons[5] = decimalPointButton;
        functionButtons[6] = clrButton;
        functionButtons[7] = delButton;

        for (JButton numButton : numButtons) {
            panel.add(numButton);
        }

        for (JButton functionButton : functionButtons) {
            functionButton.addActionListener(this);
            panel.add(functionButton);
        }

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        App calculatorApp = new App();

        {
            Calculator calculator = new Calculator();

            // Logic for CLI calculator
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
                            System.out.print("Enter number" + ((chosenOperation instanceof TrigonometricOperation) ? " (in radians)" : "") + ": ");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        for (JButton button : numButtons) {
            if (source == button) {
                // if there is already 0 in the textfield, replace it with the number on the button
                if (Objects.equals(textField.getText(), "0")) {
                    textField.setText(button.getText());
                } else {
                    textField.setText(textField.getText() + button.getText());
                }
                break;
            }
        }

        if (source == additionButton) {
            operand1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = '+';
        } else if (source == subtractionButton) {
            operand1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = '-';
        } else if (source == multiplicationButton) {
            operand1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = '*';
        } else if (source == divisionButton) {
            operand1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = '/';
        }

        if (source == equalityButton) {
            operand2 = Double.parseDouble(textField.getText());
            double result;
            switch (operator) {
                case '+':
                    Addition addition = new Addition(operand1, operand2);
                    result = addition.perform();
                    break;
                case '-':
                    Subtraction subtraction = new Subtraction(operand1, operand2);
                    result = subtraction.perform();
                    break;
                case '*':
                    Multiplication multiplication = new Multiplication(operand1, operand2);
                    result = multiplication.perform();
                    break;
                case '/':
                    Division division = new Division(operand1, operand2);
                    result = division.perform();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operator);
            }
            textField.setText(String.valueOf(result));
        }

        // if decimal point button was pressed and there is no other decimal point in the textfield
        if (source == decimalPointButton && !textField.getText().contains(".")) {
            textField.setText(textField.getText() + ".");
        }

        // if "delete" button was pressed and textfield is not empty
        if (source == delButton && !Objects.equals(textField.getText(), "")) {
            textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
        }

        if (source == clrButton) {
            operand1 = 0;
            operand2 = 0;
            operator = 0;
            textField.setText("");
        }
    }
}
