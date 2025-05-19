package HackerRank_Practise.Strings;

import java.util.Scanner;

public class StringTokerinzer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();

        String[] tokens = s.trim().split("[^A-Za-z]+");

        if (tokens.length == 1 && tokens[0].isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(tokens.length);
            for (String token : tokens) {
                System.out.println(token);
            }
        }
    }
}
