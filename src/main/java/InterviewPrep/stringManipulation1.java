package InterviewPrep;

import java.util.Arrays;

public class stringManipulation1 {
    //reverse String
    public static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }
    //reverse each word
    public static String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }
        return result.toString().trim();
    }

    //palindrome
    public static boolean isPalindrome(String str){
        String clean = str.replaceAll("[^a-zA-Z0-9]","");
        return clean.contentEquals(new StringBuilder(str).reverse());
    }

    //count vowels & consonants
    void countChars(String str){
        int vowels = 0,consonants=0;
        for(char c : str.toLowerCase().toCharArray()){
            if(Character.isLetter(c)){
                if("aeiou".indexOf(c) != -1){
                    vowels++;
                }else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " +vowels);
        System.out.println("Consonants: " +consonants);
    }

    //anagram
    public static boolean areAnagrams(String s1, String s2){
        char[] c1 = s1.replaceAll("^a-zA-Z","").toCharArray();
        char[] c2 = s2.replaceAll("^a-zA-Z","").toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1,c2);
    }

    public static void main(String[] args) {
        System.out.println("Reversed String: " +reverse("hello World !"));
        System.out.println("Reversed Each String: " +reverseWords("hello World !"));
        System.out.println("Is Palindrome: " +isPalindrome("madaM"));
        System.out.println("Is Palindrome: " +isPalindrome("father"));
        new stringManipulation1().countChars("hello World");
    }
}
