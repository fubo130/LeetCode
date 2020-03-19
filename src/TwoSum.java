import java.util.HashMap;
import java.util.Map;

/**
 * Hash table is a better approach to search element
 */
public class TwoSum {
    public static void main(String args[]) {
        int arr[] = {2, 7, 11, 5};
        int target = 9;
        BruteForce(arr, target);
        HashTable(arr, target);
        Special(arr, target);
    }

    /**
     * O (N^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] BruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("Argument Illegal");
    }

    /**
     * Better way of mapping element & index (Look up time O(N) -> O(1))
     * @param nums
     * @param target
     * @return
     */
    public static int[] HashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (map.containsKey(left) && map.get(left) != i) {
                return new int[] {i, map.get(left)};
            }
        }
        throw new IllegalArgumentException("No solution");
    }

    /**
     * Special approach One pass hash table
     * @param nums
     * @param target
     * @return
     */
    public static int[] Special(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (map.containsKey(left)) {
                return new int[] {i, map.get(left)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }
}
