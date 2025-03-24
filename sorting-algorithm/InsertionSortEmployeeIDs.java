
import java.util.Scanner;

public class InsertionSortEmployeeIDs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of employees
        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();

        int[] employeeIDs = new int[n];

        // Input: Employee IDs
        System.out.println("Enter the employee IDs:");
        for (int i = 0; i < n; i++) {
            employeeIDs[i] = scanner.nextInt();
        }

        // Applying Insertion Sort
        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i]; // Element to be inserted in sorted part
            int j = i - 1;

            // Shift elements of the sorted part that are greater than key
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }

            // Insert the key at its correct position
            employeeIDs[j + 1] = key;
        }

        // Output: Sorted Employee IDs
        System.out.println("Sorted Employee IDs:");
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }

    }
}
