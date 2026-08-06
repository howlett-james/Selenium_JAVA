package JAVAProblems.Level1;

import java.util.HashMap;
import java.util.Map;

public class CountFrequency {
    public static void main(String[] args) {
        String str = "Programming";
        char[] chars = str.replaceAll(" ","").toLowerCase().toCharArray();
        Map<Character,Integer> freq = new HashMap<>();
        for(int i =0;i<chars.length;i++){
            if(freq.containsKey(chars[i])){
                freq.put(chars[i],freq.get(chars[i])+1);
            }else {
                freq.put(chars[i],1);
            }
        }
        System.out.println(freq);
    }
}
