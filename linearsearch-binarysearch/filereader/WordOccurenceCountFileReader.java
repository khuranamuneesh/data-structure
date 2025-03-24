import java.io.*;
import java.util.Scanner;

public class WordOccurenceCountFileReader {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fileName = "example.txt"; // Replace with the actual file path
        System.out.println("Enter the Target Word to be searched: ");
        String targetWord = input.nextLine(); // Word to count
        int wordCount = 0;

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split line into words
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        wordCount++;
                    }
                }
            }

            System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in the file.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
