package calculator;

/**
 * The <code>Tangent</code> class represents the tangent function.
 */
public class Tangent extends TrigonometricOperation {

    public Tangent() {
        this.name = "Tangent";
        this.operator = "tan";
    }

    public Tangent(double a) {
        this();
        this.operand = a;
    }

    public double perform() {
        return Math.tan(this.operand);
    }

    public String showExpression() {
        return "tan(" + simplifyNumber(this.operand) + ")";
    }

}
