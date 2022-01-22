package calculator;

/**
 * The <code>Multiplication</code> class represents the operation of multiplication.
 */
public class Multiplication extends BinaryOperation {

    public Multiplication() {
        this.name = "Multiplication";
        this.operator = "*";
    }

    public Multiplication(double a, double b) {
        this();
        this.firstOperand = a;
        this.secondOperand = b;
    }

    public double perform() {
        return this.firstOperand * this.secondOperand;
    }

    public String showOperationExpression() {
        return this.firstOperand + " * " + (this.secondOperand < 0? "(": "") + this.secondOperand + (this.secondOperand < 0? ")": "");
    }

}
