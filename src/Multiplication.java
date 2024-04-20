public class Multiplication {
    public static String doMultiplication(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character == '*') {
                int leftId = ExpressionTools.findLeftValueIndex(expression, i);
                int rightId = ExpressionTools.findRightValueIndex(expression, i);

                int leftVal = ExpressionTools.convertStringToInt(expression.substring(leftId, i));
                int rightVal = ExpressionTools.convertStringToInt(expression.substring(i + 1, rightId + 1));

                int sum = leftVal * rightVal;
                expression = expression.substring(0, leftId) + sum + expression.substring(rightId + 1);

                i = 0;//TODO: This is a workaround, could use some complex math to be more efficient and go back
            }
        }
        return expression;
    }
}
