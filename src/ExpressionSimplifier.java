public class ExpressionSimplifier {
    public static String simplify(String expression) {
        expression = ExpressionTools.removeWhitespace(expression);

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character == '*') {
                expression = Multiplication.doMultiplication(expression, i);
                i = 0;
                ExpressionTools.printExpression(expression);
            } else if (character == '/') {
                expression = Division.doDivision(expression, i);
                i = 0;
                ExpressionTools.printExpression(expression);
            }
        }

        for (int i = 1; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character == '+') {
                expression = Addition.doAddition(expression, i);
                i = 0;
                ExpressionTools.printExpression(expression);
            } else if (character == '-') {
                expression = Subtraction.doSubtraction(expression, i);
                i = 0;
                ExpressionTools.printExpression(expression);
            }
        }

        return expression;
    }
}
