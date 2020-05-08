import java.util.*;

public class MaximumSubarray {
    public static void main(String args[]) {

//        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
//        System.out.println(maxSubArray(new int[]{-2,1}));
//        System.out.println(maxSubArray(new int[]{-1,-2}));
//        System.out.println(quickerSolution(new int[]{-1,-2}));
        System.out.println(quickerSolution(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     * Find the max contiguous sub array
     * Straight forward way, O(n^2), spaceO(1)
     * @param nums array of numbers
     * @return max sum of subarray
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // init max, currentCount
        int max = Integer.MIN_VALUE, currCount;
        // traverse array
        for (int i = 0; i < nums.length; i++) {
            currCount = nums[i];
            if (currCount > max) {
                max = currCount;
            }
            if (i == nums.length-1) {
                break;
            }
            // add up the rest part
            for (int j = i+1; j < nums.length; j++) {
                currCount += nums[j];
                if (currCount > max) {
                    max = currCount;
                }
            }
        }
        return max;
    }

    /**
     * Better solution with O(N) run time
     * @param nums array of numbers
     * @return max sum of subarray
     */
    public static int quickerSolution(int[] nums) {
        int currentMax = nums[0];
        int overallMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (currentMax < 0) {
                currentMax = nums[i];
            } else {
                currentMax = currentMax + nums[i];
            }
            if (currentMax > overallMax) {
                overallMax = currentMax;
            }
        }
        return overallMax;

    }

}
