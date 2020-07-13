public class BackSpaceString {
    private static final char backspace = '#';          // Const value of backspace

    public static void main(String args[]) {
        System.out.println(backspaceCompare("ad#c", "#a#c"));
    }

    /**
     * Function compare two strings
     * @param S String to compare
     * @param T String to compare
     * @return whether the two String are same
     */
    public static boolean backspaceCompare(String S, String T) {
        return convertString(S).equals(convertString(T));
    }

    /**
     * Function dealing with backspace, and return the new String
     *  O(N) run time
     * @param S String to convert
     * @return String after the backspace manipulation
     */
    public static String convertString(String S) {
        StringBuilder s = new StringBuilder(S);             // Use StringBuilder to remove element
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == backspace) {                 // Detect backspace
                if (i == 0) {                               // If backspace is the first element
                    s.deleteCharAt(i);                      // Delete backspace
                    i--;                                    // Move the iterator into next position
                } else {                                    // Backspace is not the first element
                    s.deleteCharAt(i-1);                    // Delete the character in front of backspace
                    s.deleteCharAt(i-1);                    // Delete backspace
                    i-=2;                                   // Move the iterator into next position
                }
            }
        }
        return s.toString();                                // Convert StringBuilder into String
    }
}
