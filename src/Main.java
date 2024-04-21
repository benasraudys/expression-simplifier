import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your expression: ");
        String expression = scanner.nextLine();

        //String expression = "-1-1-1+2*2-1*3+27/9/3+4/1+1/1+1/1";
        //String expression = "-1-2*6/3";
        //System.out.println(expression);

        expression = ExpressionSimplifier.simplify(expression);
        System.out.print("Solved expression: " + expression);
    }
}