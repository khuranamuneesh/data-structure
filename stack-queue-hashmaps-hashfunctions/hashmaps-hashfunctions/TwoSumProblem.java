import java.util.*;

public class TwoSumProblem {
    // Function to find two indices whose values add up to the target sum
    public static int[] twoSum(int[] num, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // Store number & its index

        for (int i = 0; i < num.length; i++) {
            int complement = target - num[i];

            // If complement is already in the map, return indices
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store the current number with its index
            map.put(num[i], i);
        }

        return new int[]{-1, -1}; // Return -1 if no valid pair found
    }

    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};
        int target = 9;

        System.out.println("Array: " + Arrays.toString(num));
        System.out.println("Target Sum: " + target);

        int[] result = twoSum(num, target);

        if (result[0] != -1) {
            System.out.println("Indices of elements: " + Arrays.toString(result));
        } else {
            System.out.println("No valid pair found.");
        }
    }
}
