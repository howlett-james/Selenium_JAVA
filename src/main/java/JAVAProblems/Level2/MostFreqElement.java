package JAVAProblems.Level2;

import java.util.HashMap;
import java.util.Map;

public class MostFreqElement {
    /*currentFreq = current frequency
           ↓
    increase currentFreq
           ↓
    store it in HashMap
           ↓
    is currentFreq > maxFreq?
           ↓
        YES
        maxFreq = currentFreq
        mostFreq = current number*/

    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 5, 3, 2, 3, 7, 3};
        Map<Integer,Integer> freq = new HashMap<>();
        int currentFreq;
        int maxFreq=0;
        int mostFreq = arr[0];
        for (int j : arr) {
            currentFreq = freq.getOrDefault(j, 0);
            currentFreq++;
            freq.put(j, currentFreq);
            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
                mostFreq = j;
            }
        }
        System.out.println(mostFreq);
    }
}
