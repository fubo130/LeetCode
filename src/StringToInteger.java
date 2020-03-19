/**
 * Use of String (immutable), StringBuilder (asynchronization), StringBuffer (synchronization)
 */
public class StringToInteger {
    public static void main(String args[]) {
        String test1 = "   -42";            // Start with space
        String test2 = "4193 with words";   // Start with number
        String test3 = "words and 987";     // Invalid, start with alphabet
        String test4 = "-91283472332";      // Invalid, out of bound

        myAtoi(test4);
    }

    /**
     * Use StringBuilder to get validate format of number
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        StringBuilder s = new StringBuilder();  // Faster & mutable
        for (char ch : str.toCharArray()) {
            if (ch == ' ' && s.length() == 0) { // Start with space, ignore
                continue;
            } else if ((ch == '+' || ch == '-') && s.length() == 0) {   // Handle with positive and negative
                s.append(ch);
            } else if (Character.isDigit(ch)) { // Append digit
                s.append(ch);
            } else {                            // Invalid case (start with alphabet)
                break;
            }
        }
        return conversion(s.toString());
    }

    /**
     * Convert String into integer *(Handle out of bound)
     * @param str
     * @return
     */
    public static int conversion(String str) {
        if (str.length() > 0 && !(str.equals("-") || str.equals("+"))) {
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException e) {
                if (str.charAt(0) == '-') {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return 0;
    }
}
