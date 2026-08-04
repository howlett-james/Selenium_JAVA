package CoreJAVA.episode_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\Selenium_JAVA\\src\\main\\resources\\aliceinwonderland.txt");
        printLines(file);
        printWords(file);
    }

    public static void printLines(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        int i =1;
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            System.out.println(i +" " +line);
            i++;
        }
    }

    public static void printWords(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        int i =1;
        while(sc.hasNext()){
            String word = sc.next();
            System.out.println(i +" " +word);
            i++;
        }
    }
    
}
