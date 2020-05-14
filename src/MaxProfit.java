import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxProfit {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 4, 7, 6 };
        System.out.println(maxProfit(arr));
    }

    /**
     * Find peak and valley of the array and calculate the profit
     * @param nums array of integers
     * @return maximum profit
     */
    public static int maxProfit(int[] nums) {
        int profit = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                profit += nums[i]-nums[i-1];
            }
        }
        return profit;
    }
}
