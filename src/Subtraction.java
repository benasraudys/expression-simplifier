public class Subtraction {
    public static String doSubtraction(String expression, int origin) {
        int leftId = ExpressionTools.findLeftValueIndex(expression, origin);
        int rightId = ExpressionTools.findRightValueIndex(expression, origin);

        int leftVal = ExpressionTools.convertStringToInt(expression.substring(leftId, origin));
        int rightVal = ExpressionTools.convertStringToInt(expression.substring(origin + 1, rightId + 1));

        int sum = leftVal - rightVal;

        System.out.println(leftVal);
        System.out.println(rightVal);
        System.out.println(sum);

        expression = expression.substring(0, leftId) + sum + expression.substring(rightId + 1);

        return expression;
    }
}
