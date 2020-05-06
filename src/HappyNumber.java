import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    static Set<Integer> set = new HashSet<>();      // Hash set check if the value already been checked

    public static void main(String args[]) {
        int num1 = 19;
        int num3 = 100;
        int num2 = 10;
        System.out.println(isHappy(num2));
    }

    /**
     * Check if the number already been checked first, and calculate result (Time: O(n), Space: O(n))
     * @param num number that been test
     * @return true if number is Happy (1^2+0^2+0^2 == 1), false if not
     */
    public static boolean isHappy(int num) {
        if (!set.contains(num)) {
            set.add(num);
        } else {
            return false;
        }
        int sum = 0;
        while (num > 0) {
            sum += Math.pow(num%10, 2);
            num/=10;
        }
        if (sum == 1) {
            return true;
        }
        return isHappy(sum);
    }
}
