package calculator;

/**
 * The <code>Operation</code> class represents an arithmetic operation.
 */
abstract public class Operation {
    protected String name;
    protected String operator;

    public String getName() {
        return this.name;
    }

    public String getOperator() {
        return operator;
    }

    /**
     * Shows the representation of the operation.
     * Something like <code>toString()</code>.
     * For example, if the operation is addition, the function will print
     * <code>first operand + second operand</code>
     * Another example: if the operation is sine, the function will print
     * <code>sin(operand)</code>
     */
    abstract public String showOperationExpression();

    /** Performs the operation.
     * @return the result of the operation
     */
    abstract public double perform();
}
