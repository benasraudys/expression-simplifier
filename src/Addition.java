public class Addition {
    public static String doAddition(String expression, int origin) {
        int leftId = ExpressionTools.findLeftValueIndex(expression, origin);
        int rightId = ExpressionTools.findRightValueIndex(expression, origin);

        int leftVal = ExpressionTools.convertStringToInt(expression.substring(leftId, origin));
        int rightVal = ExpressionTools.convertStringToInt(expression.substring(origin + 1, rightId + 1));

        int sum = leftVal + rightVal;
        expression = expression.substring(0, leftId) + sum + expression.substring(rightId + 1);

        return expression;
    }
}
