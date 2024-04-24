import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionValidator {
    public static boolean expressionHasValidChars(String expression) {
        String pattern = "^[0-9+\\-*/()\\s]+$";
        return Pattern.matches(pattern, expression);
    }

    public static boolean expressionHasEvenBrackets (String expression) {
        int bracketsCounter = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                bracketsCounter++;
            } else if (expression.charAt(i) == ')') {
                bracketsCounter--;
            }
        }
        return bracketsCounter == 0;
    }

    public static boolean expressionHasDuplicateOperators(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (i != 0) {
                    char prevChar = expression.charAt(i - 1);
                    if (prevChar == '+' || prevChar == '-' || prevChar == '*' || prevChar == '/' || (prevChar == '(' && ch != '-')) {
                        return true;
                    }
                }
                if (i != expression.length() - 1) {
                    char nextChar = expression.charAt(i + 1);
                    if (nextChar == '+' || nextChar == '-' || nextChar == '*' || nextChar == '/' || nextChar == ')') {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean expressionEndsAreOperators (String expression) {
        char firstChar = expression.charAt(0);
        if (firstChar == '+' || firstChar == '*' || firstChar == '/' || firstChar == ')') {
            return true;
        }
        char lastChar = expression.charAt(expression.length() - 1);
        if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/' || lastChar == '(') {
            return true;
        }
        return false;
    }

    public static boolean bracketsUsedProperly(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(' && i > 0 && Character.isDigit(expression.charAt(i - 1))) {
                return false;
            }
            if (ch == ')' && i < expression.length() - 1 && Character.isDigit(expression.charAt(i + 1))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isExpressionValid (String expression) {

        if (expression.isEmpty()) { return false; }

        if (expression.length() > 100) { return false; }

        if (!expressionHasValidChars(expression)) { return false; }

        if (expressionEndsAreOperators(expression)) { return false; }

        if (expressionHasDuplicateOperators(expression)) { return false; }

        if (!expressionHasEvenBrackets(expression)) { return false; }

        if (!bracketsUsedProperly(expression)) { return false; }

        return true;
    }
}
