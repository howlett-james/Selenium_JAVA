package HackerRank_Practise.Intro;

import java.util.Scanner;

public class operatorValue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String arr = scan.nextLine();
        scan.close();
        String[] operations = arr.replace("[", "").replace("]", "").replace("\"", "").split(",");
        System.out.println(new operatorValue().finalValueAfterOperations(operations));
    }
    public int finalValueAfterOperations(String[] operations){
        int X =0;
        for (String op : operations){
            op = op.trim();
            if (op.equals("--X") || op.equals("X--")) {
                X--;
            } else if (op.equals("++X") || op.equals("X++")) {
                X++;
            }
        }
        return X;
    }
}
