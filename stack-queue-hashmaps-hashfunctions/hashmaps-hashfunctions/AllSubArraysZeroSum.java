import java.util.*;

public class AllSubArraysZeroSum {

    // Function to find all subarrays with sum zero
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        // Initialize with sum 0 at index -1 to handle cases starting from index 0
        map.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Update cumulative sum

            // If sum exists in the map, it means we found subarrays summing to zero
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(new int[]{start + 1, i}); // Store subarray indices
                }
            }

            // Store this sum occurrence in the map
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return result;
    }

    // Function to print the subarrays
    public static void printSubarrays(List<int[]> subarrays) {
        if (subarrays.isEmpty()) {
            System.out.println("No subarrays with zero sum found.");
        } else {
            System.out.println("Zero Sum Subarrays (Start Index, End Index):");
            for (int[] subarray : subarrays) {
                System.out.println(Arrays.toString(subarray));
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6, -3, 2, -2, 3, 1, -4};
        System.out.println("Input Array: " + Arrays.toString(arr));

        List<int[]> zeroSumSubarrays = findZeroSumSubarrays(arr);
        printSubarrays(zeroSumSubarrays);
    }
}
