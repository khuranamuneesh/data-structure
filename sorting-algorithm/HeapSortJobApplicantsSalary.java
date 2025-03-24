import java.util.Scanner;

public class HeapSortJobApplicantsSalary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of applicants
        System.out.print("Enter the number of applicants: ");
        int n = scanner.nextInt();

        int[] salaries = new int[n];

        // Input: Salary demands
        System.out.println("Enter the expected salary demands:");
        for (int i = 0; i < n; i++) {
            salaries[i] = scanner.nextInt();
        }

        // Applying Heap Sort
        heapSort(salaries);

        // Output: Sorted salary demands
        System.out.println("Sorted salary demands:");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }

        scanner.close();
    }

    // Heap Sort function
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap root with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify function to maintain heap property
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
}

