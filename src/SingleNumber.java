import java.util.*;

public class SingleNumber {
    public static void main(String args[]) {
        int[] num1 = {2,2,1};
        int[] num2 = {4,1,2,1,2};
        System.out.println(singleNumber(num1));
        System.out.println(singleNumber(num2));
    }

    /**
     * My solution Same integer will be adjacent after sort array, so don't need to spend extra space
     *              to track single number. (Time: O(N), Space: O(1))
     * @param nums array to search for
     * @return single number found
     */
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i<nums.length-1 && nums[i] == nums[i+1]) {
                i++;
            } else {
                return nums[i];
            }
        }
        return -1;
    }
}
