package CoreJAVA.episode_11;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListConcept {
    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList<>();
        //add
        ll.add("test");
        ll.add("qtp");
        ll.add("selenium");
        ll.add("RPA");
        System.out.println("Contents of LinkedList" +ll);

        //addFirst
        ll.addFirst("Logan");
        //addLast
        ll.addLast("QA");

        System.out.println("Contents of LinkedList"+ll);

        //get
        System.out.println(ll.get(2));

        //set
        ll.set(1,"22");

        //remove first and last
        ll.removeFirst();
        ll.removeLast();
        System.out.println("Contents of LinkedList after remove"+ll);

        //remove
        ll.remove(3);
        System.out.println("Contents of LinkedList after remove"+ll);

        //print all the values of linkedList
        //1. for loop
        System.out.println("Printing all values using For loop");
        for(int i=0;i<ll.size();i++){
            System.out.println(ll.get(i));
        }
        //2.Enhanced foo loop
        System.out.println("Printing all values using enhanced for loop");
        for(String s : ll){
            System.out.println(s);
        }

        //3. Iterator
        System.out.println("Printing all values using Iterator");
        Iterator<String > it = ll.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        //4. While
        int num =0;
        while (ll.size()>=num){
            System.out.println(ll.get(num));
            num++;
        }


    }
}