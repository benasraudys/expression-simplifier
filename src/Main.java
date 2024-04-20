import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an expression: ");
        String expression = scanner.nextLine();

        System.out.println("Your expression: " + expression);

        expression = ExpressionBasics.removeWhitespace(expression);

        System.out.println("Your expression: " + expression);

        expression = Addition.doAddition(expression);

        System.out.println("Your expression: " + expression);

        //int expressionInt = ExpressionBasics.convertStringToInt(expression);

        //System.out.println("Your expression: " + expressionInt);
    }
}