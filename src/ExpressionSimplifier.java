public class ExpressionSimplifier {

    public static String simplify(String expression) {
        expression = ExpressionTools.cleanExpression(expression);
        if (!ExpressionValidator.isExpressionValid(expression)) {
            expression = null;
        }
        else {
            try {
                expression = solveMath(expression);
            } catch (NumberFormatException e) {
                return null;
            } catch (ArithmeticException e) {
                return null; // Divide by zero error
            }
        }
        return expression;
    }

    public static String solveMath(String expression) {
        Addition addition = new Addition();
        Subtraction subtraction = new Subtraction();
        Multiplication multiplication = new Multiplication();
        Division division = new Division();


        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character == '(') {
                expression = solveBrackets(expression, i);
                i = 0;
            }
        }
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character == '*') {
                expression = multiplication.doOperation(expression, i);
                i = 0;
            } else if (character == '/') {
                expression = division.doOperation(expression, i);
                i = 0;
            }
        }
        for (int i = 1; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character == '+') {
                expression = addition.doOperation(expression, i);
                i = 0;
            } else if (character == '-') {
                expression = subtraction.doOperation(expression, i);
                i = 0;
            }
        }
        return expression;
    }

    public static String solveBrackets(String expression, int origin) {
        for (int i = origin + 1; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                expression = solveBrackets(expression, i);
            } else if (expression.charAt(i) == ')') {
                String subString = expression.substring(origin + 1, i);
                subString = ExpressionSimplifier.simplify(subString);
                expression = expression.substring(0, origin) + subString + expression.substring(i + 1);
                return expression;
            }

        }
        return expression;
    }

}
