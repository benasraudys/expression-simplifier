public class ExpressionBasics {
    public static String removeWhitespace(String str) {
        return str.replaceAll("\\s", "");
    }

    public static int convertStringToInt(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        // Use Integer.parseInt() to convert the string to an integer
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            // Handle the case where the string is not a valid integer
            throw new IllegalArgumentException("Input string is not a valid integer");
        }
    }

    public static int findLeftValueIndex(String expression, int origin) {
        for (int i = origin - 1; i >= 0; i--) {
            if (!Character.isDigit(expression.charAt(i))) {
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
