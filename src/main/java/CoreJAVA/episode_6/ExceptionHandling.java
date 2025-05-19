package CoreJAVA.episode_6;

import java.util.Arrays;

public class ExceptionHandling {
    public static void main(String[] args) {
        try{
            System.out.println("Starts");
            System.out.println("Division of 10/0" +10/0);
        }catch (Exception e){
            System.out.println("Localized Message:" +e.getLocalizedMessage());
            System.out.println("Error Occurred !");
        }
        System.out.println("End !");
    }
}