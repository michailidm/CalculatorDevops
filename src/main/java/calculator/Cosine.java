package calculator;

/**
 * The <code>Cosine</code> class represents the cosine function.
 */
public class Cosine extends UnaryOperation {

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

    public String showOperationExpression() {
        return "cos(" + this.operand + ")";
    }

}
