public class ExpressionSimplifier {
    public static String simplify(String expression) {
        expression = ExpressionBasics.removeWhitespace(expression);

        System.out.println("Your expression: " + expression);

        expression = Addition.doAddition(expression);

        System.out.println("Your expression: " + expression);

        expression = Subtraction.doSubtraction(expression);

        System.out.println("Your expression: " + expression);

        return expression;
    }
}
