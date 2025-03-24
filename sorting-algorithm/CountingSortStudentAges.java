import java.util.Scanner;

public class CountingSortStudentAges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] ages = new int[n];

        // Input: Student ages (between 10 and 18)
        System.out.println("Enter the ages of students (10 to 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }

        // Applying Counting Sort
        countingSort(ages, 10, 18);

        // Output: Sorted student ages
        System.out.println("Sorted ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }

        scanner.close();
    }

    // Counting Sort function
    public static void countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Count occurrences
        for (int num : arr) {
            count[num - min]++;
        }

        // Compute cumulative frequency
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in sorted order
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Copy sorted elements back to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}

