package CollectionsFramework.ArrayListConcept;

import java.util.ArrayList;

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

    }
}
