package HackerRank_Practise.Strings;

import java.util.Scanner;

public class StringOccurrence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String target = scan.nextLine();
        String input = scan.nextLine();
        scan.close();
        System.out.println(new StringOccurrence().strStr(target,input));
    }
    /*public int strStr(String haystack, String needle){
        int hayLen = haystack.length();
        int needleLen = needle.length();
        for (int i = 0; i <= hayLen - needleLen; i++) {
            if (haystack.substring(i, i + needleLen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }*/
    public int strStr(String haystack, String needle){
        return haystack.indexOf(needle);
    }
}
