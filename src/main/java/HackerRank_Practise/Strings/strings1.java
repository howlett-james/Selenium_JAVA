package HackerRank_Practise.Strings;

import java.util.Scanner;

public class strings1 {
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
