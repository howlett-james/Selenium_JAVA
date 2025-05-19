package InterviewPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class arraysConcept {
    //remove duplicates
    List<Integer> removeDuplicates(List<Integer> list){
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    //remove duplicate and sort
    List<Integer> removeDuplicatesAndSort(List<Integer> list){
//        return list.stream().distinct().sorted().collect(Collectors.toList());
        return list.stream().distinct().sorted().toList();
    }

    //Reverse Array In-Place
    public static int[] reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(new arraysConcept().removeDuplicates(Arrays.asList(1,2,3,4,5,3,2,1,3,5,6,7,6,8,0,7,8,9)));
        System.out.println(new arraysConcept().removeDuplicatesAndSort(Arrays.asList(1,2,3,4,5,3,2,1,3,5,6,7,6,8,0,7,8,9)));
        System.out.println(Arrays.toString(reverseArray(new int[] {1,2,3,4,5,6,7,6,8,9})));
    }
}

