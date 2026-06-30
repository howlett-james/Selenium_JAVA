package CoreJAVA.episode_12;

import java.util.Scanner;

public class Threading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("You have 10 seconds to enter your name:");
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.setDaemon(true);
        thread1.start();
        System.out.print("Enter your name:");
        String name = sc.nextLine();
        System.out.println("Hello, " + name);
        sc.close();
    }
}
