package InterviewPrep;

import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        scan.close();
        System.out.println(isPalindrome(str) ? "Palindrome" :"Not a Palindrome");
    }   
    
    public static boolean isPalindrome(String str){
        str = str.trim().toLowerCase();
        if(new StringBuilder(str).reverse().toString().equals(str)){
            return true;
        }
        return false;
    }
}
