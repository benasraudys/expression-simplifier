import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an expression: ");
        String expression = scanner.nextLine();

        //String expression = "-1+2*2-1*3+27/3";
        //System.out.println(expression);

        ExpressionSimplifier.simplify(expression);
    }
}