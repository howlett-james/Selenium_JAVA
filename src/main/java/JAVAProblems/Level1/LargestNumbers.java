package JAVAProblems.Level1;

public class LargestNumbers {
    public static void main(String[] args) {
        int[] arr = {-1,-2,-3,-4,5,-6,-7,-8,-9,-10};
        int largest=arr[0];
        for(int i : arr){
            if(i>largest){
                largest=i;
            }
        }
        System.out.println(largest);
    }
}
