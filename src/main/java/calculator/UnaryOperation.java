package calculator;

/**
 * The <code>UnaryOperation</code> class represents a unary operation.
 */
abstract public class UnaryOperation extends Operation {
    protected double operand;

    public double getOperand() {
        return operand;
    }

    public void setOperand(double operand) {
        this.operand = operand;
    }

}
