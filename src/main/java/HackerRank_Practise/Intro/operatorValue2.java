package HackerRank_Practise.Intro;

import java.util.Scanner;

public class operatorValue2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String arr = scan.nextLine();
        scan.close();
        String[] operations = arr.split(",");
        System.out.println(new operatorValue2().finalValueAfterOperations(operations));
    }
    public int finalValueAfterOperations(String[] operations){
        int X =0;
        for (String op : operations){
            op = op.trim();
            if (op.contains("--")) {
                X--;
            } else if (op.contains("++")) {
                X++;
            }
        }
        return X;
    }
}
