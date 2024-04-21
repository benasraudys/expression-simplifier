public class ExpressionSimplifier {
    public static String simplify(String expression) {
        expression = ExpressionTools.removeWhitespace(expression);

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character == '-') {
                expression = Multiplication.doMultiplication(expression, i);
                i = 0;
                System.out.println("Your expression: " + expression);
            }
        }

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character == '*') {
                expression = Multiplication.doMultiplication(expression, i);
                i = 0;
                System.out.println("Your expression: " + expression);
            } else if (character == '/') {
                expression = Division.doDivision(expression, i);
                i = 0;
                System.out.println("Your expression: " + expression);
            }
        }

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character == '+') {
                expression = Addition.doAddition(expression, i);
                i = 0;
                System.out.println("Your expression: " + expression);
            } else if (character == '-') {
                expression = Subtraction.doSubtraction(expression, i);
                i = 0;
                System.out.println("Your expression: " + expression);
            }
        }

        return expression;
    }
}
