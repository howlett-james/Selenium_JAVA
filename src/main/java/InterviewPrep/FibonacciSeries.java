package InterviewPrep;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int firstTerm = 1;
        int secondTerm = 2;
        scan.close();

        System.out.println("Fibonacci Series up to " +n +" terms:");
        for(int i =1;i<=n;++i){
            System.out.println(firstTerm);
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }    
}
