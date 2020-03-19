import java.util.*;

public class ThreeSum {
    public static void main(String args[]) {
        int arr[] = {-1, 0, 1, 2, -1, -4};
        System.out.println("List: " + twoPointerApproach(arr));
    }

    /**
     * Unlike 2 sum, this solution is slow
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i]+nums[j];
                if (map.containsKey(0-sum) && map.get(0-sum) != i && map.get(0-sum) != j) {
                    int arr[] = {nums[i], nums[j], nums[map.get(0-sum)]};
                    Arrays.sort(arr);
                    List<Integer> s = new ArrayList<>();
                    for (int m : arr) {
                        s.add(m);
                    }
                    boolean flag = false;
                    for (List<Integer> l : list) {
                        Collections.sort(l);
                        if (l.equals(s)) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[map.get(0-sum)]));
                    }
                }
            }
        }
        return list;
    }

    /**
     * O(N^2)
     * @param nums
     * @return
     */
    public static List<List<Integer>> twoPointerApproach(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int left = i + 1, right = nums.length-1;
            while (left < right) {
                if (nums[left]+nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]) left++;      // skip same element
                    while (left < right && nums[right] == nums[right+1]) right--;
                }
            }
        }
        return list;
    }

}
