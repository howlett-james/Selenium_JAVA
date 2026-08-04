package JAVAProblems.Level1;

import java.util.Scanner;

public class printNnums {
    public static void main(String[] args) {
        System.out.println("Enter a number to print till:");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i=1;i<=n;i++){
            System.out.println(i);
        }
    }
}
