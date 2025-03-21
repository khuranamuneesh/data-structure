import java.util.*;

public class PairWithGivenSum {
    // Function to check if a pair with the given sum exists
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return true;
            }
            seen.add(num);
        }

        System.out.println("No pair found.");
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target Sum: " + target);

        boolean result = hasPairWithSum(arr, target);
        System.out.println("Pair exists: " + result);
    }

}
