package InterviewPrep;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        scan.close();
        System.out.println("Reverse of the String "+"\""+string+"\" is: "+reverse(string));
    }
    public static String reverse(String string){
        String[] words =string.split(" ");
        String rev="";
        for(int i =words.length -1;i>=0;i--){
            rev += words[i] +" ";
        }
        return rev.toString();
    }
}
