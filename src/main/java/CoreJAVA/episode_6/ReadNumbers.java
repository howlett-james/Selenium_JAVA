package CoreJAVA.episode_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\Selenium_JAVA\\src\\main\\resources\\Numbers.txt");
        Scanner s = new Scanner(file);
        int sum =0;
        while (s.hasNextInt()) {
            int num = s.nextInt();
            sum += num;
        }
        System.out.println("Sum of numbers :"+sum);
    }
}
