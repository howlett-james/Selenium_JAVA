package CoreJAVA.episode_6;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteIntoFile {
    static String fileLocation = "D:\\Selenium_JAVA\\src\\main\\resources\\output.txt";
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Select the Option:");
        System.out.println("1. Write Lines");
        System.out.println("2. Write Prime Numbers");
        int i = s.nextInt();
        switch (i) {
            case 1 ->
                writeLines();
            case 2 -> writePrime();
        }
    }
    public static void writeLines(){
        try (Scanner s = new Scanner(System.in)) {
            try {
                FileWriter fileWriter = new FileWriter(fileLocation);
                Boolean write = true;

                System.out.println("Enter what you wish to write :");
                String line = s.nextLine();
                fileWriter.write(line);
                fileWriter.close();
                
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        System.out.println("Done");
    }
    public static void writePrime(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Limit :");
        int n = scan.nextInt(); 
        try {
            FileWriter fileWriter = new FileWriter(fileLocation);
            fileWriter.write("");
            Boolean write = true;
            for(int num =2;num<n;num++){
                boolean primeCheck = true;
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if(num%i==0){
                        primeCheck=false;
                        break;
                    }
                }
                if(primeCheck==true){
                    fileWriter.write(num+ "\n");
                }
            }
            fileWriter.close();
            System.out.println("Done");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
