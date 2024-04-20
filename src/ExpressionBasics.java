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
            char character = expression.charAt(i);
            if (!Character.isDigit(character)) {
                return i + 1; // Return the index where the left value starts
            }
        }
        throw new IllegalArgumentException("Invalid expression: " + expression);
    }

    public static int findRightValueIndex(String expression, int origin) {
        for (int i = origin + 1; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (!Character.isDigit(character)) {
                return i - 1; // Return the index where the right value ends
            }
        }
        throw new IllegalArgumentException("Invalid expression: " + expression);
    }
}
