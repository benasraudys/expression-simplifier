public class Addition {
    public static String doAddition(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character == '+') {
                int leftId = ExpressionBasics.findLeftValueIndex(expression, i);
                int rightId = ExpressionBasics.findRightValueIndex(expression, i);

                String leftVal = expression.substring(leftId, i);
                String rightVal = expression.substring(i + 1, rightId + 1);

                System.out.println("Left Value: " + leftVal);
                System.out.println("Right Value: " + rightVal);

                int sum = ExpressionBasics.convertStringToInt(leftVal) + ExpressionBasics.convertStringToInt(rightVal);

                System.out.println("Sum: " + sum);

                expression = expression.substring(0, leftId) + sum + expression.substring(rightId + 1);

                i = 0;//TODO: This is a workaround, could use some complex math to be more efficient and go back
            }
        }
        return expression;
    }
}
