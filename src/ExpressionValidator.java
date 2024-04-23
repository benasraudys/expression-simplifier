import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionValidator {
    public static boolean expressionHasValidChars(String expression) {
        String pattern = "^[0-9+\\-*/()\\s]+$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(expression);
        return matcher.matches();
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

    public static boolean expressionHasDuplicateOperators (String expression) {
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (i != 0) {
                    char lch = expression.charAt(i-1);
                    if (lch == '+' || lch == '-' || lch == '*' || lch == '/' || (lch == '(' && ch != '-')) {
                        return true;
                    }
                }

                if (i != expression.length() - 1) {
                    char nch = expression.charAt(i+1);
                    if (nch == '+' || nch == '-' || nch == '*' || nch == '/' || nch == ')') {
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

    public static boolean isExpressionValid (String expression) {

        if (expression.isEmpty()) { return false; }

        if (expression.length() > 100) { return false; }

        if (!expressionHasValidChars(expression)) { return false; }

        if (expressionEndsAreOperators(expression)) { return false; }

        if (expressionHasDuplicateOperators(expression)) { return false; }

        if (!expressionHasEvenBrackets(expression)) { return false; }

        return true;
    }
}
