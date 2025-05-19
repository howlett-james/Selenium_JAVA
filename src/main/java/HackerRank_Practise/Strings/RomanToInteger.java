package HackerRank_Practise.Strings;

import java.util.Scanner;

public class RomanToInteger {
/*Symbol     Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000*/
    public int romanToInt(String s) {
        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = getValue(s.charAt(i));

            if (current < prevValue) {
                total -= current;
            } else {
                total += current;
            }

            prevValue = current;
        }

        return total;
    }

    private int getValue(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        if (c == 'M') return 1000;
        return 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println(new RomanToInteger().romanToInt(s));
    }
}
