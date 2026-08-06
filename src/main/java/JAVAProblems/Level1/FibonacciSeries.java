package JAVAProblems.Level1;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int previous=0;
        int current = 1;
        int next = 0;
        for(int i =next;i<n;i++){
            System.out.println(previous);
            next = previous+current;
            previous = current;
            current= next ;
        }
    }
}
