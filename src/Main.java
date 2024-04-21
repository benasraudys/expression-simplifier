import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your expression: ");
        String expression = scanner.nextLine();

        //String expression = "-1-1-1+2*2-1*3+27/9/3+4/1+1/1+1/1";
        //String expression = "-1-1-(1+2)*2-1*3+27/9/3+4/1+1/1+1/1";
        //String expression = "-(1+(5+3)*((2+4)-(2+5)+7)+2)+(-3)abc";
        //String expression = "(((((1+3)))))";
        //String expression = "((3)3) /11";

        expression = ExpressionSimplifier.simplify(expression);
        System.out.print("Solved expression: " + expression);
    }
}