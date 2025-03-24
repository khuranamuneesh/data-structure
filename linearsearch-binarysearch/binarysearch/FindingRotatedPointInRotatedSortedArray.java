public class FindingRotatedPointInRotatedSortedArray {
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If middle element is greater than rightmost element, we will search in right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else { // Otherwise, search in left half
                right = mid;
            }
        }
        return left; // Index of the smallest element (rotation point)
    }

    public static void main(String[] args) {
        int[] rotatedArray = {6, 7, 9, 15, 19, 2, 3};
        int rotationIndex = findRotationPoint(rotatedArray);
        System.out.println("Rotation point index: " + rotationIndex);
        System.out.println("Smallest element: " + rotatedArray[rotationIndex]);
    }
}

