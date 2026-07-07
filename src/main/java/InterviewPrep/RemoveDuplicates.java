package InterviewPrep;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        ArrayList<String> arr = new ArrayList<>();
        System.out.println("Enter the string: ");
        for(int i =1;i<=n;i++){
            String s = scan.next();
            arr.add(s);
        }
        scan.close();

        System.out.println(arr.stream().distinct().collect(Collectors.toList()));
    }
}
