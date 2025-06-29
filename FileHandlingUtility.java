import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class FileHandlingUtility {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get file name
        System.out.print("Enter file name (e.g., myfile.txt): ");
        String fileName = scanner.nextLine();

        // Step 2: Get content to write
        System.out.println("Enter content to write into the file:");
        String content = scanner.nextLine();
        
        // Step 3: Write content to the file
        writeToFile(fileName, content);

        // Step 4: Read file content
        readFromFile(fileName);

        // Step 5: Ask for replacement
        System.out.print("Enter word to replace: ");
        String oldWord = scanner.nextLine();

        System.out.print("Enter new word: ");
        String newWord = scanner.nextLine();

        // Step 6: Modify the file content
        modifyFile(fileName, oldWord, newWord);

        scanner.close();
    }

    public static void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("✅ File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("📄 File content:");
            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void modifyFile(String fileName, String oldText, String newText) {
        try {
            Path path = Paths.get(fileName);
            String content = Files.readString(path);
            content = content.replaceAll(oldText, newText);
            Files.writeString(path, content);
            System.out.println("✏️ File modified successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
