package CollectionsFramework.ArrayListConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class GenericArrayList {
    public static void main(String[] args) {
        ArrayList<String> studentList = new ArrayList<>();
        studentList.add("Alex");
        studentList.add("Bob");
        studentList.add("Carl");
        studentList.add("Daniel");
        studentList.add("Harrison");
        studentList.add("Jack");
        studentList.add("Karl");


        System.out.println("For Iteration");
        for(int i = 0; i < studentList.size(); i++){
            System.out.println(studentList.get(i));
        }
        //For Each
        System.out.println("For Each");
        for(String i : studentList){
            System.out.println(i);
        }

        //JDK 8 - lambda:
        System.out.println("Names Lambda");
        studentList.stream().forEach(student -> System.out.println(student));
        System.out.println("Names");
        studentList.stream().forEach(System.out::println);

        //iterator
        System.out.println("Iterator");
        Iterator<String> iterator = studentList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //list with other collection
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(numbers);

        ArrayList<String> strings = new ArrayList<>(Arrays.asList("JAVA","Python","JavaScript","PHP"));
        System.out.println(strings);
    }
}
