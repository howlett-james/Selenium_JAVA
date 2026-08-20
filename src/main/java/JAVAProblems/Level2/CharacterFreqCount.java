package JAVAProblems.Level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterFreqCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        char[] arr = string.trim().toCharArray();
        Map<Character,Integer> freq = new HashMap<>();
        for(char c : arr){
            if(freq.containsKey(c)){
                freq.put(c,freq.get(c)+1);
            }else {
                freq.put(c,freq.getOrDefault(c,1));
            }
        }
        System.out.println(freq);
    }
}
