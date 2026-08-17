package JAVAProblems.Level1;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {10,1,2,13,5};
        int largest = 0,secondLargest=0;
        for(int i =0;i<arr.length;i++){
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        System.out.println("Second Largest: "+secondLargest);
    }
}
