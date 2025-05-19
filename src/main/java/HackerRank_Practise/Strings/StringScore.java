package HackerRank_Practise.Strings;

import java.util.Scanner;

public class StringScore {
    public int findScore(String s){
        int score=0;
        for(int i=1;i<s.length();i++){
            score += Math.abs(s.charAt(i)- s.charAt(i-1));
        }
        return score;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        s.close();
        System.out.println(new StringScore().findScore(str));
    }
}
