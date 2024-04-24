public abstract class Operation {
    public String doOperation(String expression, int origin) {
        int leftId = ExpressionTools.findLeftValueIndex(expression, origin);
        int rightId = ExpressionTools.findRightValueIndex(expression, origin);

        int leftVal = ExpressionTools.convertStringToInt(expression.substring(leftId, origin));
        int rightVal = ExpressionTools.convertStringToInt(expression.substring(origin + 1, rightId + 1));

        int result = calculate(leftVal, rightVal);
        expression = expression.substring(0, leftId) + result + expression.substring(rightId + 1);

        return expression;
    }

    protected abstract int calculate(int leftVal, int rightVal);
}
