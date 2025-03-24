
import java.io.*;

public class ReadFileLineByLine {
    public static void main(String[] args) {
        String fileName = "example.txt"; // Replace with the actual file path

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

