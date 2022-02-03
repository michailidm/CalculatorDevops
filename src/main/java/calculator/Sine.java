package calculator;

/**
 * The <code>Sine</code> class represents the sine function.
 */
public class Sine extends TrigonometricOperation {

    public Sine() {
        this.name = "Sine";
        this.operator = "sin";
    }

    public Sine(double a) {
        this();
        this.operand = a;
    }

    public double perform() {
        return Math.sin(this.operand);
    }

    public String showExpression() {
        return "sin(" + simplifyNumber(this.operand) + ")";
    }

}
