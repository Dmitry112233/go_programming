package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayMergeUtil {

    public List mergeArrays(List arr1, List arr2){

        HashSet<Integer> set = new HashSet();
        set.addAll(arr1);
        set.addAll(arr2);

        return set.stream().sorted().collect(Collectors.toList());
    }

    public void printArray(List list){
        list.stream().forEachOrdered((p) -> System.out.println(p));
    }

    public List generateExpectedArray(String expectedArrStr){
        ArrayList array = new ArrayList<>();
        for (String str : expectedArrStr.split(" ")) {
            try {
                array.add(Integer.valueOf(str));
            }catch (NumberFormatException e){
                System.out.println("Incorrect string format: " + str);
            }
        }
        return array;
    }
}
