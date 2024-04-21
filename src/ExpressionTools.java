public class ExpressionTools {
    public static String removeWhitespace(String str) {
        return str.replaceAll("\\s", "");
    }

    public static void printExpression(String expression) {
        System.out.print("Solving: " + expression);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <= expression.length() + 100; i++) {
            System.out.print("\b");
        }
    }

    public static int convertStringToInt(String number) {
        if (number == null || number.isEmpty()) {
            return 0;
        } else if (number.length() > 15) {
            throw new IllegalArgumentException("Input string cannot more than 15 chars long");
        }
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input string is not a valid integer");
        }
    }

    public static int findLeftValueIndex(String expression, int origin) {
        for (int i = origin - 1; i >= 0; i--) {
            Character character = expression.charAt(i);
            if (character == '-') {
                return i;
            } else if (!Character.isDigit(character) ) {
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
