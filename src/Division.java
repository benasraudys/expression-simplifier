public class Division {
    public static String doDivision(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character == '/') {
                int leftId = ExpressionBasics.findLeftValueIndex(expression, i);
                int rightId = ExpressionBasics.findRightValueIndex(expression, i);

                int leftVal = ExpressionBasics.convertStringToInt(expression.substring(leftId, i));
                int rightVal = ExpressionBasics.convertStringToInt(expression.substring(i + 1, rightId + 1));

                int sum = leftVal / rightVal;
                expression = expression.substring(0, leftId) + sum + expression.substring(rightId + 1);

                i = 0;//TODO: This is a workaround, could use some complex math to be more efficient and go back
            }
        }
        return expression;
    }

}
