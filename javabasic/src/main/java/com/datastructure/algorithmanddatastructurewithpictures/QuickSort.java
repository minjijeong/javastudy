package com.datastructure.algorithmanddatastructurewithpictures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args){
        Integer[] array = {30,50,7,40,88,15,44,55,22,33,77,99,11,66,1,85};
        System.out.println(Arrays.toString(array));
        List<Integer> aList = new ArrayList<>();
        aList.addAll(Arrays.asList(array));

        aList = (ArrayList<Integer>) quicksort(aList);
        System.out.println(aList.toString());
    }

    private static <T extends Comparable<? super T>> List<T> quicksort(List<T> list) {
        if(list.size() <= 1) return list;
        int pivot = list.size() /2 ;
        List<T> a = new ArrayList<T>();
        List<T> b = new ArrayList<T>();
        int c = 0;
        for(T number : list){
            if(list.get(pivot).compareTo(number) < 0) b.add(number);
            else if(list.get(pivot).compareTo(number) > 0) a.add(number);
            else c++;
        }
        a = quicksort(a);
        for(int i=0; i < c; i++)
            a.add(list.get(pivot));
        b = quicksort(b);
        List<T> sorted = new ArrayList<>();
        sorted.addAll(a);
        sorted.addAll(b);
        return sorted;
    }
}
