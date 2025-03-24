public class FindingFirstLastOccurrenceOfElement {

    // Helper function to find the first occurrence of the target
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;  // Record the position
                right = mid - 1;  // Continue searching on the left side
            } else if (arr[mid] < target) {
                left = mid + 1;  // Search the right side
            } else {
                right = mid - 1;  // Search the left side
            }
        }

        return result;
    }

    // Helper function to find the last occurrence of the target
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;  // Record the position
                left = mid + 1;  // Continue searching on the right side
            } else if (arr[mid] < target) {
                left = mid + 1;  // Search the right side
            } else {
                right = mid - 1;  // Search the left side
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 5, 6};
        int target = 2;

        int firstOccurrence = findFirstOccurrence(arr, target);
        int lastOccurrence = findLastOccurrence(arr, target);

        System.out.println("First Occurrence of " + target + ": " + firstOccurrence);
        System.out.println("Last Occurrence of " + target + ": " + lastOccurrence);
    }
}
