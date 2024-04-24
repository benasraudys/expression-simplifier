//2024 OOP Project
//Author: Benas Raudys
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager();
        String inputFilePath;
        String outputFilePath = "out.txt";

        if (args.length == 0) {
            System.out.print("Please enter file path: ");
            inputFilePath = scanner.nextLine();
            scanner.close();
        } else {
            inputFilePath = String.join(" ", args);
        }

        fileManager.createOutputFile(outputFilePath);

        System.out.println("Please note that incorrect expressions will return 'null'");

        List<String> expressions = fileManager.readFile(inputFilePath);
        for (String expression : expressions) {
            expression = ExpressionSimplifier.simplify(expression);
            fileManager.outputExpressions(expression, outputFilePath);
        }
    }
}