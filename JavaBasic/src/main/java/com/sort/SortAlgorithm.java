package com.sort;

import java.util.Arrays;
import java.util.List;
class SortAlgorithm {

    static void print(Integer [] arr) {
        Arrays.asList(arr).forEach(System.out::println);
    }

    static <T> boolean swap(T [] arr,int ida,int idb){
        T swap=arr[ida];
        arr[ida]=arr[idb];
        arr[idb]=swap;
        return true;
    }
}
