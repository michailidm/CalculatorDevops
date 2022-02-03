package calculator;

/**
 * The <code>Exponential</code> class represents the exponential operation.
 */
public class Exponential extends UnaryOperation {

    public Exponential() {
        this.name = "Exponential";
        this.operator = "exp";
    }

    public Exponential(double a) {
        this();
        this.operand = a;
    }

    public double perform() {
        return Math.exp(this.operand);
    }

    public String showExpression() {
        return "exp(" + simplifyNumber(this.operand) + ")";
    }

}
