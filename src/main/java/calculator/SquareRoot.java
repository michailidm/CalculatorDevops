package calculator;

/**
 * The <code>SquareRoot</code> class represents the square root operation.
 */
public class SquareRoot extends UnaryOperation {

    public SquareRoot() {
        this.name = "Square Root";
        this.operator = "√";
    }

    public SquareRoot(double a) {
        this();
        this.operand = a;
    }

    public double perform() {
        return Math.sqrt(this.operand);
    }

    public String showExpression() {
        return "√" + (this.operand < 0? "(": "") + simplifyNumber(this.operand) + (this.operand < 0? ")": "");
    }

}
