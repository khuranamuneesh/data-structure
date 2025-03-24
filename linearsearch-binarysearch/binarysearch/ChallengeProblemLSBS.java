import java.util.Arrays;

public class ChallengeProblemLSBS {

    // Function to find the first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its correct position if possible
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with its correct position
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Step 2: Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1; // If all numbers are in order, return next positive number
    }

    // Function to perform binary search in a sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;  // Target found
            } else if (arr[mid] < target) {
                left = mid + 1;  // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1, 7, 2};

        // Finding the first missing positive integer
        int missingNumber = findFirstMissingPositive(nums);
        System.out.println("First missing positive integer: " + missingNumber);

        // Sorting array before binary search
        Arrays.sort(nums);
        System.out.println("Sorted Array: " + Arrays.toString(nums));

        // Searching for target using binary search
        int target = 4;
        int targetIndex = binarySearch(nums, target);
        System.out.println("Index of target (" + target + "): " + targetIndex);
    }
}
