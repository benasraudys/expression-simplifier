import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionTools {

    public static String cleanExpression (String expression) {
        expression = removeJunk(expression);
        return expression;
    }

    public static boolean isExpressionValid (String expression) {
        int bracketsCounter = 0;
        if (expression.length() > 50) {
            return false;
        }
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                bracketsCounter++;
            } else if (expression.charAt(i) == ')') {
                bracketsCounter--;
            }
        }
        return bracketsCounter == 0;
    }

    public static String removeJunk(String expression) {
        Pattern pattern = Pattern.compile("[^\\d\\-+*/()]+");
        Matcher matcher = pattern.matcher(expression);
        return matcher.replaceAll("");
    }

    public static void printExpression(String expression) {
        System.out.println("Solving: " + expression);
    }

    public static int convertStringToInt(String number) {
        if (number == null || number.isEmpty()) {
            return 0;
        }
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
