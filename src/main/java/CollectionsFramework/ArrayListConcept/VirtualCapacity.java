package CollectionsFramework.ArrayListConcept;

import java.util.ArrayList;

public class VirtualCapacity {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        System.out.println(list.size());
        list.add(100);
        System.out.println(list.size());
        list.add(200);
        list.add(300);
        list.add(400);
        list.add(500);
        list.add(600);
    }
}
