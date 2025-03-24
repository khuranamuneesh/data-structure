import java.util.Scanner;

public class QuickSortProductPrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of products
        System.out.print("Enter the number of products: ");
        int n = scanner.nextInt();

        double[] prices = new double[n];

        // Input: Product prices
        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextDouble();
        }

        // Applying Quick Sort
        quickSort(prices, 0, n - 1);

        // Output: Sorted product prices
        System.out.println("Sorted product prices:");
        for (double price : prices) {
            System.out.print(price + " ");
        }

        scanner.close();
    }

    // Quick Sort function
    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition function
    public static int partition(double[] arr, int low, int high) {
        double pivot = arr[high]; // Choosing the last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot element with the element at i+1
        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return the partition index
    }
}

