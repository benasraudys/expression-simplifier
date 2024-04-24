public class ExpressionTools {
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
