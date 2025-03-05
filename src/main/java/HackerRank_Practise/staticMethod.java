package HackerRank_Practise;

import java.util.Scanner;

public class staticMethod {
/*  * Input Format:
        There are two lines of input. The first line contains B: the breadth of the parallelogram. The next line contains H: the height of the parallelogram.
    * Constraints:
        * -100 <= B <= 100
        * -100 <= H <= 100
    *Output Format:
        If both values are greater than zero, then the main method must output the area of the parallelogram.
        Otherwise, print "java.lang.Exception: Breadth and height must be positive" without quotes. */
    static int B,H;
    static boolean flag;

    static {
        Scanner scanner = new Scanner(System.in);
        B=scanner.nextInt();
        H = scanner.nextInt();

        if(B>0 && H>0){
            flag =true;
        }else {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
            flag = false;
        }
    }
    public static void main(String[] args) {
        if(flag){
            System.out.println(B*H);
        }
    }
}
