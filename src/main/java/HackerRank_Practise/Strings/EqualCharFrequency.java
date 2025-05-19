package HackerRank_Practise.Strings;

import java.util.Scanner;

public class EqualCharFrequency {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        scan.close();
        int count = 0;
        char firstChar = s.charAt(0);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) ==firstChar){
                count++;
            }
        }
        for(int i =1;i<s.length();i++){
            char currentChar = s.charAt(i);
            int tempcount=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j) == currentChar){
                    tempcount++;
                }
            }
            if(tempcount != count){
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
