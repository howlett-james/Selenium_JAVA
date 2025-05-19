package HackerRank_Practise.Intro;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n= s.nextInt();
        int result =1;
        for(int i=result;i<=n;i++){
            result *= i;
        }
        System.out.println("Factorial of "+n+" is "+result);
    }
}