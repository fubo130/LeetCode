import java.security.KeyStore;
import java.util.*;

public class GroupAnagrams {
    public static void main(String args[]) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        ArrayList<List> list = new ArrayList(groupAnagrams(arr));
    }

    /**
     * A function groups the word has same letters, use Hashmap (Key: "sorted characters", value: "list of word")
     * @param strs list of strings
     * @return grouped strings
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<String, List>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }

}
