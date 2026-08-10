package JAVAProblems.Level1;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int fact =1 ;
        for(int i =2;i<=n;i++){
            fact = i*fact;
        }
        System.out.println(fact);
    }
}
