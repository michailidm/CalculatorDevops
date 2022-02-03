package calculator;

/**
 * The <code>Cosine</code> class represents the cosine function.
 */
public class Cosine extends TrigonometricOperation {

    public Cosine() {
        this.name = "Cosine";
        this.operator = "cos";
    }

    public Cosine(double a) {
        this();
        this.operand = a;
    }

    public double perform() {
        return Math.cos(this.operand);
    }

    public String showExpression() {
        return "cos(" + simplifyNumber(this.operand) + ")";
    }

}
