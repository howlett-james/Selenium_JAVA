package NEETCode_Practise.ArraysHashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int longest = 0;
        for (int val : set) {
            if(!set.contains(val-1)){
                int length=1;
                while(set.contains(val+length)){
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        LongestConsecutive lc = new LongestConsecutive();
        System.out.println(lc.longestConsecutive(new int[]{2,20,4,10,3,4,5}));
        System.out.println(lc.longestConsecutive(new int[]{0,3,2,5,4,6,1,1}));
    }
}
