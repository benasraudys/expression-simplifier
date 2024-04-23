import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<String> readFile(String filePath) {
        List<String> expressions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                expressions.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error: Incorrect file path");
            System.exit(127);
        }

        return expressions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String filePath;

        if (args.length == 0) {
            System.out.print("Please enter file path: ");
            filePath = scanner.nextLine();
        }
        else {
            filePath = String.join(" ", args);
        }

        List<String> expressions = readFile(filePath);
        for (String expression : expressions) {
            expression = ExpressionSimplifier.simplify(expression);
            System.out.println("Solved expression: " + expression);
        }
    }
}