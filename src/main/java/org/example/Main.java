package org.example;

import org.example.sorting.SortingAnalysis;

import java.util.Arrays;

import static org.example.sorting.GenerateRandomArray.generateRandomArray;

public class Main {
    public static void main(String[] args) {
        Integer[] array1 = generateRandomArray();
        Integer[] array2 = Arrays.copyOf(array1, array1.length);
        Integer[] array3 = Arrays.copyOf(array1, array1.length);

        long start1 = System.currentTimeMillis();
        SortingAnalysis.sortBubble(array1);
        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();
        SortingAnalysis.sortInsertion(array2);
        System.out.println(System.currentTimeMillis() - start2);

        long start3 = System.currentTimeMillis();
        SortingAnalysis.sortSelection(array3);
        System.out.println(System.currentTimeMillis() - start3);
    }
}