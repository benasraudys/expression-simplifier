public class ExpressionSimplifier {
    public static String simplify(String expression) {
        expression = ExpressionTools.removeWhitespace(expression);

        System.out.println("Your expression: " + expression);

        expression = Multiplication.doMultiplication(expression);

        System.out.println("Your expression: " + expression);

        expression = Division.doDivision(expression);

        System.out.println("Your expression: " + expression);

        expression = Addition.doAddition(expression);

        System.out.println("Your expression: " + expression);

        expression = Subtraction.doSubtraction(expression);

        System.out.println("Your expression: " + expression);

        return expression;
    }
}
