package calculator;

/**
 * The <code>Division</code> class represents the operation of division.
 */
public class Division extends BinaryOperation {

    public Division() {
        this.name = "Division";
        this.operator = "/";
    }

    public Division(double a, double b) {
        this();
        this.firstOperand = a;
        this.secondOperand = b;
    }

    public double perform() {
        return this.firstOperand / this.secondOperand;
    }

    public String showOperationExpression() {
        return this.firstOperand + " / " + (this.secondOperand < 0? "(": "") + this.secondOperand + (this.secondOperand < 0? ")": "");
    }

}
