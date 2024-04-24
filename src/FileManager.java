import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public List<String> readFile(String filePath) {
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

    public void createOutputFile(String outputFilePath) {
        try {
            FileOutputStream fos = new FileOutputStream(outputFilePath, false);
        } catch (IOException e) {
            System.err.println("Error: Couldn't open file for writing");
            System.exit(2);
        }
    }

    public void outputExpressions(String expression, String outputFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath, true))) {
            writer.write("Solution: " + expression);
            writer.newLine();
            writer.flush();

            System.out.println("Solution: " + expression);
        } catch (IOException e) {
            System.err.println("Error: Couldn't open file for writing");
            System.exit(3);
        }
    }

}
