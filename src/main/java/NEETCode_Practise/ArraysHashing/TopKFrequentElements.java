package NEETCode_Practise.ArraysHashing;

import java.util.*;

public class TopKFrequentElements {
    /* 
    CREATE empty map freq

    // Count frequencies
    FOR each num in nums:
        IF num exists in freq:
            freq[num] = freq[num] + 1
        ELSE:
            freq[num] = 1

    // Convert map into list of (number, frequency) pairs
    pairs = empty list

    FOR each (number, count) in freq:
        ADD (number, count) to pairs

    // Sort by frequency in descending order
    SORT pairs by count decreasing

    result = empty list

    // Take first k elements
    FOR i from 0 to k - 1:
        ADD pairs[i].number to result

    RETURN result
    */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num,0)+1);
        }

        List<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            arr.add(new int[] {entry.getValue(),entry.getKey()});
        }

        arr.sort((a,b)-> b[0] - a[0]);

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }

        return res;
    }
    public char[] topKFrequent(char[] nums, int k) {
        Map<Character,Integer> freq = new HashMap<>();
        for (char num : nums) {
            freq.put(num, freq.getOrDefault(num,0)+1);
        }

        List<int[]> arr = new ArrayList<>();
        for(Map.Entry<Character,Integer> entry : freq.entrySet()){
            arr.add(new int[] {entry.getValue(),entry.getKey()});
        }

        arr.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] a,int[] b){
                return b[0] - a[0];
            }
        });

        char[] res = new char[k];

        for (int i = 0; i < k; i++) {
            res[i] = (char) arr.get(i)[1];
        }

        return res;
    }
    public static void main(String[] args) {
        TopKFrequentElements obj = new TopKFrequentElements();
        System.out.println(Arrays.toString(obj.topKFrequent(new char[]{'a','b','a','b','c','a','d'}, 1))); 
    }
}
