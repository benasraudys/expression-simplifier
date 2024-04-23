import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFilePath;
        String outputFilePath = "out.txt";

        if (args.length == 0) {
            System.out.print("Please enter file path: ");
            inputFilePath = scanner.nextLine();
        } else {
            inputFilePath = String.join(" ", args);
        }

        FileManager.createOutputFile(outputFilePath);

        List<String> expressions = FileManager.readFile(inputFilePath);
        for (String expression : expressions) {
            expression = ExpressionSimplifier.simplify(expression);
            FileManager.outputExpressions(expression, outputFilePath);
        }
    }
}