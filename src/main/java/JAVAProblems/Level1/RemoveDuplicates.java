package JAVAProblems.Level1;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,5,5,6};
        Set<Integer> duplicates = new HashSet<>();
        for(int num : arr){
            duplicates.add(num);
        }
        System.out.println(duplicates.stream().toList());
    }
}
