package JAVAProblems.Level1;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=0;i<arr.length;i++){
            if(n==arr[i]){
                System.out.println("Search Item is found at "+(i+1)+"'th place");
                break;
            }
        }
    }
}
