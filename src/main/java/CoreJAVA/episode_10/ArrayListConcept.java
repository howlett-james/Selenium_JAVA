package CoreJAVA.episode_10;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListConcept {
    public static void main(String[] args) {
        //Dynamic Array -- ArrayList
        //contain duplicate values/elements
        //synchronized
        //allows random access to fetch the elements because it stores the values on the basis of indeces

        //Non-Generic
        ArrayList ar = new ArrayList();

        ar.add(12);
        ar.add(1213);
        ar.add(12324);
        System.out.println(ar.size());
        ar.add(138);
        ar.add(8982);
        System.out.println(ar.size());
        ar.add("fad");
        ar.add("fasdkjfh");
        ar.add("kfhs");
        ar.add(212.12);
        ar.add('a');
        System.out.println(ar.size());//size of arraylist
        ar.remove(5);
        System.out.println(ar.get(5));//print a value based on index
        //to print all the values of ArrayList
        //1. for loop
        //2. Iterator

        for (int i =0;i<ar.size();i++){
            System.out.println(ar.get(i));
        }


        //Generic
        ArrayList<Integer> arrayListInt = new ArrayList<>();
        arrayListInt.add(213);
        arrayListInt.add(6514);

        ArrayList<String> arrayListString = new ArrayList<>();
        arrayListString.add("asfjs");
        arrayListString.add("dfjsn");

        ArrayList<Object> arrayListObject = new ArrayList<>();
        arrayListObject.add(12);
        arrayListObject.add("safd");
        arrayListObject.add('s');
        arrayListObject.add(12.21);

        //Employee class Objects:
        Employee e1 = new Employee("Logan",22,"QA");
        Employee e2 = new Employee("James Howlett",22,"QA");
        Employee e3 =  new Employee("Yokesh", 22,"QA");

        //creating ArrayList
        ArrayList<Employee> arrayListEmp = new ArrayList<>();
        arrayListEmp.add(e1);
        arrayListEmp.add(e2);
        arrayListEmp.add(e3);

        //Iterator to traverse the values
        Iterator<Employee> it = arrayListEmp.iterator();
        while (it.hasNext()){
            Employee emp = it.next();
            System.out.println(emp.name+","+emp.age+","+emp.dept);
        }
        //addAll
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("test");
        arrayList1.add("selenium");
        arrayList1.add("QTP");

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("test");
        arrayList2.add("JAVA");
        arrayList2.add("JavaScript");

        //adding 2nd list to 1st
        arrayList1.addAll(arrayList2);
        for (Object o :
                arrayList1) {
            System.out.println(o);
        }

        //removeAll
        arrayList1.removeAll(arrayList2);
        for (Object o :
                arrayList1) {
            System.out.println(o);
        }
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("test");
        arrayList3.add("selenium");
        arrayList3.add("QTP");

        ArrayList<String> arrayList4 = new ArrayList<>();
        arrayList4.add("test");
        arrayList4.add("JAVA");
        arrayList4.add("JavaScript");



        //retainAll
        arrayList3.retainAll(arrayList4);
        for(int x=0;x<arrayList3.size();x++){
            System.out.println(arrayList3.get(x));
        }
    }
}