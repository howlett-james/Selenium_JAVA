package CollectionsFramework.ArrayListConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraylistExcercise {
    public static void main(String[] args) {
        //default class
        //dynamic array

        //default Generics
        ArrayList<Object> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add("Test");
        list.add(null);
        list.add(true);
        list.add(12.33);
        list.add(list);
        System.out.println(list);
    }
}
