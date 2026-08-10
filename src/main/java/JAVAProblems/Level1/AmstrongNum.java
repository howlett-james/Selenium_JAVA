package JAVAProblems.Level1;

import java.util.Map;
import java.util.Scanner;

public class AmstrongNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        char[] chars = s.toCharArray();
        double armsNum =0;
        for(char c: chars){
            int n = Integer.parseInt(String.valueOf(c));
            armsNum += Math.pow(n,chars.length);
        }
        System.out.println(armsNum==Integer.parseInt(s) ? "Armstrong Number" : "Not an Armstrong Num");
    }
}
