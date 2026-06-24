package NEETCode_Practise.ArraysHashing;

import org.jspecify.annotations.NonNull;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String @NonNull [] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if (!res.containsKey(sortedStr)) {
                res.put(sortedStr, new ArrayList<>());
            }
            res.get(sortedStr).add(s);
        }
        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        System.out.println(ga.groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"}));
        System.out.println(ga.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(ga.groupAnagrams(new String[]{"listen", "silent", "enlist", "google", "gogole", "cat"}));
        System.out.println(ga.groupAnagrams(new String[]{""}));
    }
}
