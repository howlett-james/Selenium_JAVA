package CoreJAVA.episode_7;

public class CallByValueAndCallByReg {
    int p,q;
    public static void main(String[] args) {
        CallByValueAndCallByReg obj = new CallByValueAndCallByReg();
        int x=10;
        int y=20;
        obj.testsum(x,y);//call by value or pass by value

        obj.p = 50;
        obj.q = 60;

        obj.swap(obj);
        //after swap
        System.out.println(obj.p+""+ obj.q);

    }

    public int testsum(int a, int b){
        int c=a+b;
        return c;
    }
    //Call by reference
    public void swap(CallByValueAndCallByReg t){
        int temp;
        temp = t.p; //temp =50
        t.p = t.q; //t.p = 60
        t.q = temp; //t.q = 50
    }
}