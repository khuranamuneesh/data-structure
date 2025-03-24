
import java.util.Scanner;

public class SelectionSortExamScores  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] scores = new int[n];

        // Input: Exam scores
        System.out.println("Enter the exam scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        // Applying Selection Sort
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }

        // Output: Sorted exam scores
        System.out.println("Sorted exam scores:");
        for (int score : scores) {
            System.out.print(score + " ");
        }

    }
}
