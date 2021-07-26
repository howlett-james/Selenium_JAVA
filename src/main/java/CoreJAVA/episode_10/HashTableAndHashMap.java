package CoreJAVA.episode_10;

import java.util.Hashtable;

public class HashTableAndHashMap {
    public static void main(String[] args) {
        Hashtable h = new Hashtable();
        h.put("A","Test");
        h.put("B","Hello");
        h.put("C","World");
        System.out.println(h.size());

        h.put(1,213);
        h.put(2,421);
        h.put(3,459);
        System.out.println(h.size() );

        System.out.println(h.get(3));
        System.out.println(h.get("C"));

        Hashtable<Integer,Integer>  ht = new Hashtable<>();
        ht.put(1,21);
        ht.put(2,12);

        Hashtable<String,String> hts = new Hashtable<>();
        hts.put("a","Selenium");
        hts.put("b","QA");

        Hashtable<Integer,Object> hto = new Hashtable<>();
        hto.put(1,"Logan");
        hto.put(2,"Tester");
        hto.put(3,22);


    }
}