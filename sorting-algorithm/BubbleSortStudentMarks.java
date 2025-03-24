
import java.util.Scanner;

public class BubbleSortStudentMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] marks = new int[n];

        // Input: Student marks
        System.out.println("Enter the marks of students:");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }

        // Applying Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // To check if any swapping happened
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) { // Swap if the element is greater than the next
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // If no swaps in a pass, array is sorted
        }

        // Output: Sorted marks
        System.out.println("Sorted marks:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }

        scanner.close();
    }
}
