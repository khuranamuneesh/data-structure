
import java.io.*;
import java.util.StringTokenizer;

public class CompareFourPerformance {
    public static void main(String[] args) {
        compareStringBuilderAndBuffer();
        compareFileReaderAndInputStreamReader("large_text_file.txt"); // Update with your actual file path
    }

    // Method to compare StringBuilder and StringBuffer
    private static void compareStringBuilderAndBuffer() {
        final int ITERATIONS = 1_000_000;
        String text = "hello";

        // StringBuilder Performance
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1_000_000 + " ms");

        // StringBuffer Performance
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < ITERATIONS; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Method to compare FileReader and InputStreamReader for reading a large file
    private static void compareFileReaderAndInputStreamReader(String fileName) {
        try {
            // FileReader Performance
            long startTime = System.nanoTime();
            int wordCount = countWordsUsingFileReader(fileName);
            long endTime = System.nanoTime();
            System.out.println("FileReader: " + wordCount + " words, Time: " + (endTime - startTime) / 1_000_000 + " ms");

            // InputStreamReader Performance
            startTime = System.nanoTime();
            wordCount = countWordsUsingInputStreamReader(fileName);
            endTime = System.nanoTime();
            System.out.println("InputStreamReader: " + wordCount + " words, Time: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Count words using FileReader
    private static int countWordsUsingFileReader(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        int wordCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            wordCount += new StringTokenizer(line).countTokens(); // Count words in each line
        }
        br.close();
        return wordCount;
    }

    // Count words using InputStreamReader
    private static int countWordsUsingInputStreamReader(String fileName) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName));
        BufferedReader br = new BufferedReader(isr);
        int wordCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            wordCount += new StringTokenizer(line).countTokens();
        }
        br.close();
        return wordCount;
    }
}
