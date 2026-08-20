package JAVAProblems.Level2;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCounting {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 5, 3, 2};
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num : arr){
            if(freq.containsKey(num)){
                freq.put(num,freq.get(num)+1);
            }else {
                freq.put(num,freq.getOrDefault(num,1));
            }
        }
        System.out.println(freq);
    }
}
