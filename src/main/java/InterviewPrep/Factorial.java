package InterviewPrep;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int fact =1;
        for(int i =1;i<=n;i++){
            fact *= i;
        }
        scan.close();
        System.out.println("Factorial of "+n+" is: "+fact);
    }    
}
