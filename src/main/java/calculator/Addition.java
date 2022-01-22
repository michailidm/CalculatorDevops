package calculator;

/**
 * The <code>Addition</code> class represents the operation of addition.
 */
public class Addition extends BinaryOperation {

    public Addition() {
        this.name = "Addition";
        this.operator = "+";
    }

    public Addition(double a, double b) {
        this();
        this.firstOperand = a;
        this.secondOperand = b;
    }

    public double perform() {
        return this.firstOperand + this.secondOperand;
    }

    public String showOperationExpression() {
        return this.firstOperand + " + " + (this.secondOperand < 0? "(": "") + this.secondOperand + (this.secondOperand < 0? ")": "");
    }

}
