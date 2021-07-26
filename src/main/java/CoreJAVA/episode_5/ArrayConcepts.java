package CoreJAVA.episode_5;

public class ArrayConcepts {
    public static void main(String[] args) {
        //One Dimensional Array
        //dis-advantages of array:
        //1.Size is fixed -- static array -- to overcome this problem, we use Collections -- ArrayList, HashTable --dynamic array
        //2.Stores only similar data types -- to overcome this problem, we use Object Array
        int[] i = new int[4];
        i[0] = 10;
        i[1] = 10;
        i[2] = 10;
        i[3] = 10;
//        i[4] = 40;
        System.out.println(i[1]);
        System.out.println(i.length); //print size of array

        //System.out.println(Arrays.stream(i).count());
        //to print all the values -- for loop

        for(int j = 0; j<i.length;j++){
            System.out.println(i[j]);
        }

        for (int k : i) {
            System.out.println(k);
        }
        //ArrayIndexOutOfBoundsException - exceeds the limit of array

        //Object Array: -- object is a super class in JAVA
        Object[] ob = new Object[5];
        ob[0] = "Tom"; //string
        ob[1] = 21;//int
        ob[2] = 21.08;//double
        ob[3] = "21/08/1999";
        ob[4] = "London";

        for (Object o : ob) {// range 1,2,3,4,5
            System.out.println(o);
        }
        /*for (Object o : ob) {  Anonymous Array
            System.out.println(o);
        }*/



    }
}