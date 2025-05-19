package HackerRank_Practise.Strings;

import java.util.Scanner;

public class splitFun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] chars = string.toCharArray();
        char[] reversed = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == ' ') reversed[i] = aChar;
        }

        var j = chars.length-1;
        for (char aChar : chars) {
            if (aChar != ' ') {
                while (chars[j] == ' ') {
                    j--;
                }
                reversed[j] = aChar;
                j--;
            }
        }
        System.out.println(new String(reversed));
    }
}
