package calculator;

/**
 * The <code>Subtraction</code> class represents the operation of subtraction.
 */
public class Subtraction extends BinaryOperation {

    public Subtraction() {
        this.name = "Subtraction";
        this.operator = "-";
    }

    public Subtraction(double a, double b) {
        this();
        this.firstOperand = a;
        this.secondOperand = b;
    }

    public double perform() {
        return this.firstOperand - this.secondOperand;
    }

    public String showExpression() {
        return simplifyNumber(this.firstOperand) + " - " + (this.secondOperand < 0? "(": "") + simplifyNumber(this.secondOperand) + (this.secondOperand < 0? ")": "");
    }

}
