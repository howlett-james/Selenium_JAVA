package CoreJAVA.episode_4;

public class Loops {
    public static void main(String[] args) {
        //1. While Loop
        System.out.println("*******WHILE LOOP***********");
        int i = 1;
        while (i<=10) {
            System.out.println(i);
            i++; //i=i+1
        }
        //2. do While
        System.out.println("*******DO WHILE LOOP********");
        int i1 = 1;
        do {
            System.out.println(i);
            i++;
        }while (i<=10);

        //for loop
        System.out.println("**********FOR LOOP**********");
        for(int j=1;j<=10;j++){
            System.out.println(j);
        }
        int count =0;
        for(int x=1;x<=5;x++){
            for(int y=1; y<=5;y++){
                for(int z=1;z<=5;z++){
                    System.out.println(x+""+y+""+z);
                    count +=1;
                }
            }
        }
        System.out.println("Count "+count);
    }
}