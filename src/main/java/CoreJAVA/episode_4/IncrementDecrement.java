package CoreJAVA.episode_4;

public class IncrementDecrement {
    public static void main(String[] args) {
        //++
        //--

        //Post Increment
        int i=1;
        System.out.println(i);//1
        System.out.println(i++);//1 -->2 increment
        System.out.println(i++);//2 --> 3 increment

//        int j =i++;
        System.out.println(i);//2
        /*System.out.println(j);//1
        j = i++;
        System.out.println(j);//2*/

        //Pre Increment
        int a = 2;
        int b = ++a;
        System.out.println(a);//3
        System.out.println(b);//3

        //Post Decrement
        int m = 2;
        System.out.println(m);//2 -->1 decrement
        int n = m--;
        System.out.println(m);//1
        System.out.println(n);//2
        System.out.println(m);//1

        //Pre Decrement
        int p = 2;
        System.out.println(p);//2
        int q = --p; //--q = q-1
        System.out.println(p);//1
        System.out.println(q);//1
    }
}