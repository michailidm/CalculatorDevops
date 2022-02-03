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
     * Shows the numeric expression produced by the operation.
     * Something like <code>toString()</code>.
     * For example, if the operation is addition, the function will print
     * <code>first_operand + second_operand</code>
     * Another example: if the operation is sine, the function will print
     * <code>sin(operand)</code>
     */
    abstract public String showExpression();

    /** Performs the operation.
     * @return the result of the operation
     */
    abstract public double perform();

    /**
     * Simplifies the number given. Specifically:
     * <ul>
     * <li>removes redundant zeros (e.g. 45.0 -> 45)</li>
     * <li>removes minus sign if it is minus zero.(-0 -> 0)</li>
     * </ul>
     */
    public String simplifyNumber(double number) {
        String resultString;
        if (number == (int) number) {
            resultString = String.valueOf((int) number);
        } else {
            resultString = String.valueOf(number);
        }
        return resultString;
    }

}
