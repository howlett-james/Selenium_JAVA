package JAVAProblems.Level1;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 41, 10, 87, 25, 120, 63};
        System.out.println(Arrays.binarySearch(Arrays.stream(arr).sorted().toArray(),63));
        Arrays.sort(arr);
        int left =0;
        int right = arr.length-1;
        Scanner scan = new Scanner(System.in);
        int target = scan.nextInt();

        while (left <= right){
            int middle = (left + right)/2;
            if(target==arr[middle]){
                System.out.println("Found at "+middle+"'th Place");
                break;
            }else if(target<arr[middle]){
                right = middle-1;
            }else {
                left=middle+1;
            }
        }
    }
}
