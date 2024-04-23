import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExpressionTools {

    public static String cleanExpression (String expression) {
        expression = removeWhitespace(expression);
        return expression;
    }

    public static boolean expressionHasValidChars(String expression) {
        String pattern = "^[0-9+\\-*/()\\s]+$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(expression);
        return matcher.matches();
    }

    public static boolean isExpressionValid (String expression) {

        if (expression.isEmpty()) { return false; }

        if (!expressionHasValidChars(expression)) { return false; }

        Character lastChar = expression.charAt(expression.length()-1);
        if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/' || lastChar == '(') { return false; }

        if (expression.length() > 100) {
            return false;
        }
        for (int i = 0; i < expression.length(); i++) {
            Character ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (i != 0) {
                    Character lch = expression.charAt(i-1);
                    if (lch == '+' || lch == '-' || lch == '*' || lch == '/' || (lch == '(' && ch != '-')) {
                        return false;
                    }
                }

                if (i != expression.length() - 1) {
                    Character nch = expression.charAt(i+1);
                    if (nch == '+' || nch == '-' || nch == '*' || nch == '/' || nch == ')') {
                        return false;
                    }
                }
            }
        }
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

    public static String removeWhitespace(String expression) {
        return expression.replaceAll("\\s", "");
    }

    public static int convertStringToInt(String number) {
        if (number == null || number.isEmpty()) {
            return 0;
        }
        // If error occurs it's caught by ExpressionSimplifier.simplify()
        return Integer.parseInt(number);
    }

    public static int findLeftValueIndex(String expression, int origin) {
        for (int i = origin - 1; i >= 0; i--) {
            if (expression.charAt(i) == '-') {
                return i;
            } else if (!Character.isDigit(expression.charAt(i))) {
                return i + 1;
            }
        }
        return 0;
    }

    public static int findRightValueIndex(String expression, int origin) {
        for (int i = origin + 1; i < expression.length(); i++) {
            if (!Character.isDigit(expression.charAt(i))) {
                return i - 1;
            }
        }
        return expression.length()-1;
    }
}
