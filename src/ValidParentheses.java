public class ValidParentheses {
    public static void main(String args[]) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "([{}])";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
    }

    public static boolean isValid(String s) {
        StringBuilder str = new StringBuilder(s);
        char l, r;
        for (int i = 0; i < str.length()-1 && str.length() > 0; i++) {
            l = str.charAt(i);
            if (l == '(' || l == '{' || l == '[') {
                for (int j = i+1; j < str.length(); j++) {
                    r = str.charAt(j);
                    if (r == l+1 || r == l+2) {
                        str.deleteCharAt(i);
                        str.deleteCharAt(j-1);
                        i--;
                        break;
                    }
                }
            }
        }
        return str.length()==0;
    }
}
