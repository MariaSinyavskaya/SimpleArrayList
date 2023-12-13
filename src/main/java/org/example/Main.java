package org.example;

import org.example.impl.SimpleArrayListImpl;
import org.example.sorting.SortingAnalysis;

import java.util.Arrays;

import static org.example.sorting.GenerateRandomArray.generateRandomArray;

public class Main {
    public static void main(String[] args) {
        SimpleArrayListImpl arrayList = new SimpleArrayListImpl();

        arrayList.add(6);
        arrayList.add(2);
        arrayList.add(8);
        arrayList.add(3);
        arrayList.add(1);

        System.out.println(arrayList.contains(1));
    }
}