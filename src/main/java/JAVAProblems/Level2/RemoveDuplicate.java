package JAVAProblems.Level2;

import java.util.*;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 5, 3, 2, 7};
        List<Integer> duplicates = new ArrayList<>();
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            if(freq.containsKey(arr[i])){
                freq.put(arr[i],freq.get(arr[i])+1);
                if(freq.get(arr[i])>1 && !duplicates.contains(arr[i])){
                    duplicates.add(arr[i]);
                }
            }else {
                freq.put(arr[i],freq.getOrDefault(arr[i],1));
            }
        }
        System.out.println(duplicates);
    }
}
