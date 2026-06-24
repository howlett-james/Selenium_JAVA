package NEETCode_Practise.ArraysHashing;

import java.util.*;

public class GroupAnagramS2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> res = new HashMap<>();
        for(String s: strs){
            char[] c = s.toLowerCase().toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            res.putIfAbsent(sorted,new ArrayList<>());
            res.get(sorted).add(s);
        }
        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
        GroupAnagramS2 ga2 = new GroupAnagramS2();
        System.out.println(ga2.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
