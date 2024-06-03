import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is task 2 for java internship");
        System.out.print("Enter a text or type 'file' to read from a file: ");
        String input = scanner.nextLine();
        String text = "";
        if (input.equalsIgnoreCase("file")) {
            System.out.print("Enter the file name: ");
            String fileName = scanner.nextLine();
            try {
                File file = new File(fileName);
                Scanner fileScanner = new Scanner(file);
                StringBuilder fileContent = new StringBuilder();
                while (fileScanner.hasNextLine()) {
                    fileContent.append(fileScanner.nextLine()).append(" ");
                }
                fileScanner.close();
                text = fileContent.toString().trim();
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please make sure the file exists and try again.");
                return;
            }
        } else {
            text = input;
        }
        String[] words = text.split("[\\s.,;!?]+");
        int wordCount = words.length;
        System.out.println("Total words: " + wordCount);
    }
}
