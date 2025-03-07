package HackerRank_Practise.Strings;

import java.util.Scanner;

public class strings1 {
    /*Given a string s and two indices, start and end, print a substring consisting of all characters in the inclusive range from start to end - 1.
    Input Format:
        The first line contains a single string s.
        The second line contains two space-separated integers denoting the values of start and end.
    Constraints:
        1 ≤ |s| ≤ 100 (The length of s is between 1 and 100).
        0 ≤ start < end ≤ n (The indices should be within a valid range).
        s consists of only English alphabetic letters (a-z, A-Z).
    Output Format:
        Print the substring from start to end - 1.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int[] indices = getValidIndices(scanner,s.length());
        System.out.println(s.substring(indices[0],indices[1]));
        scanner.close();

    }
    public static int[] getValidIndices(Scanner sc , int length){
        int start,end;
        while (true){
            System.out.println("Enter the start and end indices:");
            start = sc.nextInt();
            end=sc.nextInt();

            if(start>=0 && end<=length & start <end){
                return new int[]{start,end};
            }else{
                System.out.println("Invalid indices! Please Try Again.");
            }
        }
    }
}
