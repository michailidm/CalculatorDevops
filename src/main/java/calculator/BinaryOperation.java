package calculator;

/**
 * The <code>BinaryOperation</code> class represents a binary operation.
 */
abstract public class BinaryOperation extends Operation {
    protected double firstOperand;
    protected double secondOperand;

    public double getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

}
