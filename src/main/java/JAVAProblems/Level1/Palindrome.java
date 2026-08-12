package JAVAProblems.Level1;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        boolean isPalindrome = true;
        for(int i =0;i< s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome ? "Palindrome" : "Not a Palindrome");
    }
}
