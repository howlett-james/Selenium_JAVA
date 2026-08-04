package JAVAProblems.Level1;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i=0;i<arr.length/2;i++){
            int j = arr.length-1-i;
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
